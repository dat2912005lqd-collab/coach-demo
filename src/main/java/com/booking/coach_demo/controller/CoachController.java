package com.booking.coach_demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;
import com.booking.coach_demo.entity.loaixe;
import com.booking.coach_demo.entity.xe;
import com.booking.coach_demo.entity.lichtrinhxe;
import com.booking.coach_demo.service.XeService;
import com.booking.coach_demo.service.LichTrinhService;
import com.booking.coach_demo.service.ThongKeService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CoachController {
    @Autowired
    private XeService xeService;
    @Autowired
    private LichTrinhService lichTrinhService;
    @Autowired
    private ThongKeService thongKeService;
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
    @GetMapping("/thongke/thu-nhap-nha-xe")
    public String getThuNhapNhaXe(@RequestParam String maXe) {
        // Logic to retrieve the revenue for a specific xe
        return "Tong thu nhap cho xe: " + thongKeService.tinhThuNhap(maXe);
    }
}
