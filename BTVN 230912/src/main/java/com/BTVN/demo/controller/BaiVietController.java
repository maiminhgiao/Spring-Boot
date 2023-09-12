package com.BTVN.demo.controller;

import com.BTVN.demo.entity.BaiVietEntity;
import com.BTVN.demo.entity.TacGiaEntity;
import com.BTVN.demo.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/baiviet")

public class BaiVietController {

    @Autowired
    BaiVietRepository baiVietRepository;

    @GetMapping("")
    public ResponseEntity<?> getBaiViet() {
        List<BaiVietEntity> listBaiViet = baiVietRepository.findAll();
        return new ResponseEntity<>( listBaiViet, HttpStatus.OK);
    }

    @PostMapping("")

    public ResponseEntity<String> addBaiViet(@RequestBody BaiVietEntity baiVietEntity){
        String messSuccess = "thêm thành công " + baiVietRepository.save(baiVietEntity);
        return ResponseEntity.ok(messSuccess);
    }


    @DeleteMapping("/{id}") // khai báo pathvariable
    public ResponseEntity<?> deleteBaiViet(@PathVariable String id) {
        try {
            int conVertId = Integer.parseInt(id);
            return new ResponseEntity<>("xóa thành công " + conVertId   , HttpStatus.OK);

        }catch (NumberFormatException e){
            return new ResponseEntity<>("Không thể convert dữ liệu từ String -> Integer" , HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/update/{id}")

    public ResponseEntity<?> updateBaiViet(@PathVariable int id, @RequestBody BaiVietEntity baiVietEntity){
        Optional<BaiVietEntity> optionalBaiViet = baiVietRepository.findById(id);

        if (optionalBaiViet.isPresent()) {
            BaiVietEntity timkiemBaiViet = optionalBaiViet.get();

            timkiemBaiViet.setTieuDe(baiVietEntity.getTieuDe());
            timkiemBaiViet.setNoiDung(baiVietEntity.getNoiDung());
            timkiemBaiViet.setIdTacGia(baiVietEntity.getIdTacGia());
            timkiemBaiViet.setNgayViet(baiVietEntity.getNgayViet());

            baiVietRepository.save(timkiemBaiViet);

            return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không tìm thấy bài viết", HttpStatus.NOT_FOUND);
        }
    }

}