package com.booking.coach_demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;
import com.booking.coach_demo.entity.loaixe;
import com.booking.coach_demo.entity.xe;
import com.booking.coach_demo.entity.lichtrinhxe;
import com.booking.coach_demo.service.XeService;
import com.booking.coach_demo.service.LichTrinhService;
import com.booking.coach_demo.service.ThongKeService;
import com.booking.coach_demo.dto.LichTrinhRequestDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:10000")
@RequestMapping("/api")
public class CoachController {
    @Autowired
    private XeService xeService;
    @Autowired
    private LichTrinhService lichTrinhService;
    @Autowired
    private ThongKeService thongKeService;
    
    // ========== XE ENDPOINTS ==========
    @PostMapping("/xes")
    public xe addXe(@RequestBody xe xe) {
        return xeService.addXe(xe);
    }
    
    @GetMapping("/xes")
    public List<xe> getAllXe() {
        return xeService.getAllXe();
    }
    
    @GetMapping("/xe/{maXe}")
    public xe getXeById(@PathVariable String maXe) {
        // Logic to retrieve a specific xe by its ID
        return xeService.getXeById(maXe);
    }
    
    // ========== LICH HANH TRINH ENDPOINTS ==========
    @PostMapping("/xe/{maXe}/lich-hanh-trinh")
    public lichtrinhxe updateXeLichHanhTrinh(@PathVariable String maXe, @RequestBody lichtrinhxe lht) {
        // Generate ID for the lichtrinhxe
        lht.setId(UUID.randomUUID().toString());
        // Logic to update the xe's schedule in the database
        return lichTrinhService.addLichTrinh(lht);
    }
    
    @GetMapping("/xe/{maXe}/lich-hanh-trinh")
    public List<lichtrinhxe> getXeLichHanhTrinh(@PathVariable String maXe) {
        return lichTrinhService.getByMaXe(maXe);
    }
    
    // ========== THONG KE ENDPOINTS ==========
    @GetMapping("/thongke/thu-nhap-nha-xe")
    public String getThuNhapNhaXe(@RequestParam String maXe) {
        // Logic to retrieve the revenue for a specific xe
        return "Tong thu nhap cho xe: " + thongKeService.tinhThuNhap(maXe);
    }
    
    // ========== BOOKING ENDPOINTS ==========
    
    /**
     * Đặt vé xe
     * POST /api/bookings/lich-trinh/{lichTrinhId}
     */
    @PostMapping("/bookings/lich-trinh/{lichTrinhId}")
    public Map<String, Object> bookingTicket(@PathVariable String lichTrinhId, 
                                             @RequestBody LichTrinhRequestDTO request) {
        return lichTrinhService.bookingTicket(lichTrinhId, request);
    }
    
    /**
     * Lấy thông tin đặt vé
     * GET /api/bookings/lich-trinh/{lichTrinhId}/{bookingId}
     */
    @GetMapping("/bookings/lich-trinh/{lichTrinhId}/{bookingId}")
    public Map<String, Object> getBookingInfo(@PathVariable String lichTrinhId, 
                                              @PathVariable String bookingId) {
        return lichTrinhService.getBookingInfo(lichTrinhId, bookingId);
    }
    
    /**
     * Xác nhận đặt vé
     * PUT /api/bookings/lich-trinh/{lichTrinhId}/{bookingId}/confirm
     */
    @PutMapping("/bookings/lich-trinh/{lichTrinhId}/{bookingId}/confirm")
    public Map<String, Object> confirmBooking(@PathVariable String lichTrinhId, 
                                              @PathVariable String bookingId) {
        return lichTrinhService.confirmBooking(lichTrinhId, bookingId);
    }
    
    /**
     * Huỷ đặt vé
     * PUT /api/bookings/lich-trinh/{lichTrinhId}/{bookingId}/cancel
     */
    @PutMapping("/bookings/lich-trinh/{lichTrinhId}/{bookingId}/cancel")
    public Map<String, Object> cancelBooking(@PathVariable String lichTrinhId, 
                                             @PathVariable String bookingId) {
        return lichTrinhService.cancelBooking(lichTrinhId, bookingId);
    }
    
    /**
     * Lấy danh sách ghế trống
     * GET /api/bookings/lich-trinh/{lichTrinhId}/available-seats
     */
    @GetMapping("/bookings/lich-trinh/{lichTrinhId}/available-seats")
    public List<String> getAvailableSeats(@PathVariable String lichTrinhId) {
        return lichTrinhService.getAvailableSeats(lichTrinhId);
    }
    
    /**
     * Lấy danh sách tất cả booking của một lịch trình
     * GET /api/bookings/lich-trinh/{lichTrinhId}/all
     */
    @GetMapping("/bookings/lich-trinh/{lichTrinhId}/all")
    public List<Map<String, Object>> getAllBookings(@PathVariable String lichTrinhId) {
        return lichTrinhService.getAllBookings(lichTrinhId);
    }
}
