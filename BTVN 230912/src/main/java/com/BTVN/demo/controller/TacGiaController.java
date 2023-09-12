package com.BTVN.demo.controller;

import com.BTVN.demo.entity.BaiVietEntity;
import com.BTVN.demo.entity.TacGiaEntity;
import com.BTVN.demo.repository.BaiVietRepository;
import com.BTVN.demo.repository.TacGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tacgia")
public class TacGiaController {

    @Autowired
    TacGiaRepository tacGiaRepository;

    @GetMapping("")
    public ResponseEntity<?> getTacGia(){
        List<TacGiaEntity> listTacGia = tacGiaRepository.findAll();
        return new ResponseEntity<>(listTacGia, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> addTacGia(@RequestBody TacGiaEntity tacGiaEntity){
        String messSuccess = "thêm thành công " + tacGiaRepository.save(tacGiaEntity);
        return ResponseEntity.ok(messSuccess);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBaiViet(@PathVariable int id) {
        tacGiaRepository.deleteById(id);
        return new ResponseEntity<>("xóa thành công rồi ", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBaiViet(@PathVariable int id, @RequestBody TacGiaEntity tacGiaEntity){

        Optional<TacGiaEntity> timKiemTacGia = tacGiaRepository.findById(id);
        if(timKiemTacGia.isPresent()){
            TacGiaEntity tacGia = timKiemTacGia.get();

            tacGia.setTenTacGia(tacGiaEntity.getTenTacGia());
            tacGia.setHoTen(tacGiaEntity.getHoTen());
            tacGia.setGioiTinh(tacGiaEntity.getGioiTinh());

            tacGiaRepository.save(tacGia);
            return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không tìm thấy bài viết", HttpStatus.NOT_FOUND);
        }
    }

}



