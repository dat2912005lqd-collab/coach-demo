package com.booking.coach_demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.coach_demo.repository.LichTrinhRepository;
import com.booking.coach_demo.entity.lichtrinhxe;
import com.booking.coach_demo.dto.LichTrinhRequestDTO;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class LichTrinhService {
    @Autowired
    private LichTrinhRepository lichTrinhRepository;
    
    // Map lưu trữ thông tin booking: key = lichTrinhId, value = tập hợp các ghế đã đặt
    private static final java.util.Map<String, java.util.Map<String, BookingInfo>> bookingStore = 
        new java.util.HashMap<>();
    
    public static class BookingInfo {
        public String tenHanhKhach;
        public String soDienThoai;
        public String email;
        public String soGhe;
        public String ghiChu;
        public String trangThai; // PENDING, CONFIRMED, CANCELLED
        public java.time.LocalDateTime ngayTao;
        
        public BookingInfo(String tenHanhKhach, String soDienThoai, String email, 
                          String soGhe, String ghiChu) {
            this.tenHanhKhach = tenHanhKhach;
            this.soDienThoai = soDienThoai;
            this.email = email;
            this.soGhe = soGhe;
            this.ghiChu = ghiChu;
            this.trangThai = "PENDING";
            this.ngayTao = java.time.LocalDateTime.now();
        }
    }
    
    public lichtrinhxe addLichTrinh(lichtrinhxe lichtrinhxe){
        return lichTrinhRepository.save(lichtrinhxe);
    }
    
    public List<lichtrinhxe> getByMaXe(String maxe){
        return lichTrinhRepository.findByXe_Maxe(maxe);
    }
    
    /**
     * Đặt vé xe - tạo booking mới
     */
    public java.util.Map<String, Object> bookingTicket(String lichTrinhId, LichTrinhRequestDTO request) {
        java.util.Map<String, Object> response = new java.util.HashMap<>();
        
        // Validate input
        if (request.getTenHanhKhach() == null || request.getTenHanhKhach().trim().isEmpty()) {
            response.put("success", false);
            response.put("message", "Tên hành khách không được để trống");
            return response;
        }
        if (request.getSoDienThoai() == null || request.getSoDienThoai().trim().isEmpty()) {
            response.put("success", false);
            response.put("message", "Số điện thoại không được để trống");
            return response;
        }
        
        // Kiểm tra lịch trình có tồn tại
        Optional<lichtrinhxe> lichTrinhOpt = lichTrinhRepository.findById(lichTrinhId);
        if (!lichTrinhOpt.isPresent()) {
            response.put("success", false);
            response.put("message", "Lịch trình không tồn tại");
            return response;
        }
        
        lichtrinhxe lichTrinh = lichTrinhOpt.get();
        
        // Kiểm tra ghế đã đặt chưa
        if (request.getSoGhe() != null && !request.getSoGhe().isEmpty()) {
            if (isSeatBooked(lichTrinhId, request.getSoGhe())) {
                response.put("success", false);
                response.put("message", "Ghế " + request.getSoGhe() + " đã được đặt");
                return response;
            }
        }
        
        // Kiểm tra số lượng ghế
        int totalSeats = lichTrinh.getCapacity();
        int bookedSeats = getBookedSeatsCount(lichTrinhId);
        if (bookedSeats >= totalSeats) {
            response.put("success", false);
            response.put("message", "Xe đã hết chỗ");
            return response;
        }
        
        // Tạo booking
        String bookingId = java.util.UUID.randomUUID().toString();
        BookingInfo booking = new BookingInfo(
            request.getTenHanhKhach(),
            request.getSoDienThoai(),
            request.getEmail(),
            request.getSoGhe(),
            request.getGhiChu()
        );
        
        if (!bookingStore.containsKey(lichTrinhId)) {
            bookingStore.put(lichTrinhId, new java.util.HashMap<>());
        }
        bookingStore.get(lichTrinhId).put(bookingId, booking);
        
        response.put("success", true);
        response.put("message", "Đặt vé thành công");
        response.put("bookingId", bookingId);
        response.put("tenHanhKhach", booking.tenHanhKhach);
        response.put("soDienThoai", booking.soDienThoai);
        response.put("soGhe", booking.soGhe);
        response.put("giaVe", lichTrinh.getTuyenXe().getDonGia());
        response.put("trangThai", booking.trangThai);
        response.put("ngayTao", booking.ngayTao);
        
        return response;
    }
    
    /**
     * Huỷ đặt vé
     */
    public java.util.Map<String, Object> cancelBooking(String lichTrinhId, String bookingId) {
        java.util.Map<String, Object> response = new java.util.HashMap<>();
        
        if (!bookingStore.containsKey(lichTrinhId)) {
            response.put("success", false);
            response.put("message", "Lịch trình không tồn tại");
            return response;
        }
        
        java.util.Map<String, BookingInfo> bookings = bookingStore.get(lichTrinhId);
        if (!bookings.containsKey(bookingId)) {
            response.put("success", false);
            response.put("message", "Không tìm thấy đặt vé");
            return response;
        }
        
        BookingInfo booking = bookings.get(bookingId);
        booking.trangThai = "CANCELLED";
        
        response.put("success", true);
        response.put("message", "Huỷ vé thành công");
        response.put("bookingId", bookingId);
        response.put("trangThai", booking.trangThai);
        
        return response;
    }
    
    /**
     * Xác nhận đặt vé
     */
    public java.util.Map<String, Object> confirmBooking(String lichTrinhId, String bookingId) {
        java.util.Map<String, Object> response = new java.util.HashMap<>();
        
        if (!bookingStore.containsKey(lichTrinhId)) {
            response.put("success", false);
            response.put("message", "Lịch trình không tồn tại");
            return response;
        }
        
        java.util.Map<String, BookingInfo> bookings = bookingStore.get(lichTrinhId);
        if (!bookings.containsKey(bookingId)) {
            response.put("success", false);
            response.put("message", "Không tìm thấy đặt vé");
            return response;
        }
        
        BookingInfo booking = bookings.get(bookingId);
        booking.trangThai = "CONFIRMED";
        
        response.put("success", true);
        response.put("message", "Xác nhận vé thành công");
        response.put("bookingId", bookingId);
        response.put("trangThai", booking.trangThai);
        
        return response;
    }
    
    /**
     * Lấy thông tin đặt vé
     */
    public java.util.Map<String, Object> getBookingInfo(String lichTrinhId, String bookingId) {
        java.util.Map<String, Object> response = new java.util.HashMap<>();
        
        if (!bookingStore.containsKey(lichTrinhId)) {
            response.put("success", false);
            response.put("message", "Lịch trình không tồn tại");
            return response;
        }
        
        java.util.Map<String, BookingInfo> bookings = bookingStore.get(lichTrinhId);
        if (!bookings.containsKey(bookingId)) {
            response.put("success", false);
            response.put("message", "Không tìm thấy đặt vé");
            return response;
        }
        
        BookingInfo booking = bookings.get(bookingId);
        Optional<lichtrinhxe> lichTrinhOpt = lichTrinhRepository.findById(lichTrinhId);
        
        response.put("success", true);
        response.put("bookingId", bookingId);
        response.put("tenHanhKhach", booking.tenHanhKhach);
        response.put("soDienThoai", booking.soDienThoai);
        response.put("email", booking.email);
        response.put("soGhe", booking.soGhe);
        response.put("ghiChu", booking.ghiChu);
        response.put("trangThai", booking.trangThai);
        response.put("ngayTao", booking.ngayTao);
        
        if (lichTrinhOpt.isPresent()) {
            lichtrinhxe lichTrinh = lichTrinhOpt.get();
            response.put("giaVe", lichTrinh.getTuyenXe().getDonGia());
            response.put("maXe", lichTrinh.getMaxe());
            response.put("tenTuyenDuong", lichTrinh.getTuyenXe().getTentuyen());
            response.put("ngayGioXuatBen", lichTrinh.getNgayGioXuatBen());
        }
        
        return response;
    }
    
    /**
     * Lấy danh sách ghế trống
     */
    public List<String> getAvailableSeats(String lichTrinhId) {
        Optional<lichtrinhxe> lichTrinhOpt = lichTrinhRepository.findById(lichTrinhId);
        if (!lichTrinhOpt.isPresent()) {
            throw new IllegalArgumentException("Lịch trình không tồn tại");
        }
        
        lichtrinhxe lichTrinh = lichTrinhOpt.get();
        int capacity = lichTrinh.getCapacity();
        
        Set<String> bookedSeats = new HashSet<>();
        if (bookingStore.containsKey(lichTrinhId)) {
            for (BookingInfo booking : bookingStore.get(lichTrinhId).values()) {
                if (!booking.trangThai.equals("CANCELLED") && booking.soGhe != null) {
                    bookedSeats.add(booking.soGhe);
                }
            }
        }
        
        List<String> availableSeats = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            String seatNumber = "A" + i;
            if (!bookedSeats.contains(seatNumber)) {
                availableSeats.add(seatNumber);
            }
        }
        
        return availableSeats;
    }
    
    /**
     * Lấy danh sách tất cả booking của một lịch trình
     */
    public List<java.util.Map<String, Object>> getAllBookings(String lichTrinhId) {
        List<java.util.Map<String, Object>> bookingList = new ArrayList<>();
        
        if (!bookingStore.containsKey(lichTrinhId)) {
            return bookingList;
        }
        
        java.util.Map<String, BookingInfo> bookings = bookingStore.get(lichTrinhId);
        Optional<lichtrinhxe> lichTrinhOpt = lichTrinhRepository.findById(lichTrinhId);
        
        for (String bookingId : bookings.keySet()) {
            BookingInfo booking = bookings.get(bookingId);
            java.util.Map<String, Object> bookingMap = new java.util.HashMap<>();
            bookingMap.put("bookingId", bookingId);
            bookingMap.put("tenHanhKhach", booking.tenHanhKhach);
            bookingMap.put("soDienThoai", booking.soDienThoai);
            bookingMap.put("email", booking.email);
            bookingMap.put("soGhe", booking.soGhe);
            bookingMap.put("ghiChu", booking.ghiChu);
            bookingMap.put("trangThai", booking.trangThai);
            bookingMap.put("ngayTao", booking.ngayTao);
            
            if (lichTrinhOpt.isPresent()) {
                lichtrinhxe lichTrinh = lichTrinhOpt.get();
                bookingMap.put("giaVe", lichTrinh.getTuyenXe().getDonGia());
            }
            
            bookingList.add(bookingMap);
        }
        
        return bookingList;
    }
    
    /**
     * Kiểm tra ghế đã đặt chưa
     */
    private boolean isSeatBooked(String lichTrinhId, String soGhe) {
        if (!bookingStore.containsKey(lichTrinhId)) {
            return false;
        }
        
        java.util.Map<String, BookingInfo> bookings = bookingStore.get(lichTrinhId);
        for (BookingInfo booking : bookings.values()) {
            if (!booking.trangThai.equals("CANCELLED") && 
                booking.soGhe != null && booking.soGhe.equals(soGhe)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Đếm số ghế đã đặt
     */
    private int getBookedSeatsCount(String lichTrinhId) {
        if (!bookingStore.containsKey(lichTrinhId)) {
            return 0;
        }
        
        java.util.Map<String, BookingInfo> bookings = bookingStore.get(lichTrinhId);
        int count = 0;
        for (BookingInfo booking : bookings.values()) {
            if (!booking.trangThai.equals("CANCELLED")) {
                count++;
            }
        }
        return count;
    }
}
