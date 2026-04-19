package com.booking.coach_demo.dto;
import java.time.LocalDateTime;
import com.booking.coach_demo.entity.lichtrinhxe;
public class XeResponseDTO {
    private String maxe;
    private String bienSo;
    private String tenTaiXe;
    private String tenNhaXe;
    private String maTuyen;
    private String tenTuyen;
    private LocalDateTime ngayGioXuatBen;
    public XeResponseDTO(String maxe, String bienSo, String tenTaiXe, String tenNhaXe, String maTuyen, String tenTuyen, LocalDateTime ngayGioXuatBen) {
        this.maxe = maxe;
        this.bienSo = bienSo;
        this.tenTaiXe = tenTaiXe;
        this.tenNhaXe = tenNhaXe;
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;
        this.ngayGioXuatBen = ngayGioXuatBen;
    }
    public String getMaxe() {
        return maxe;
    }
    public String getBienSo() {
        return bienSo;
    }
    public String getTenTaiXe() {
        return tenTaiXe;
    }
    public String getTenNhaXe() {
        return tenNhaXe;
    }
    public String getMaTuyen() {
        return maTuyen;
    }
    public String getTenTuyen() {
        return tenTuyen;
    }
    public LocalDateTime getNgayGioXuatBen() {
        return ngayGioXuatBen;
    }
    public XeResponseDTO mapToDTO(lichtrinhxe lht) {
        return new XeResponseDTO(
            lht.getMaxe(),
            lht.getBienSo(),
            lht.getTenTaiXe(),
            lht.getTenNhaXe(),
            lht.getMaTuyen(),
            lht.getTenTuyen(),
            lht.getNgayGioXuatBen()
        );
    }
}
