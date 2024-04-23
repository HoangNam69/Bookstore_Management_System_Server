/*
 * @ (#) Main.java       22/4/24
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

import dao.NhanVienDao;
import entities.NhanVien;
import service.impl.NhanVienServiceImpl;

import java.time.LocalDate;

/*
 * @description: This class is used for testing
 * @author: Nguyen Hong Duc
 * @date:   22/4/24
 */
public class Main {

    public static void main(String[] args) throws Exception {
        NhanVien nv = new NhanVien("NV000002", "Jack 5 củ",
                LocalDate.of(2002, 11, 9), "02120120462",
                "Ho Chi Minh", "0969828711", true, "leminhbao@gmail.com", false,
                false, "nvduy.jpg");
        boolean checkUpdate = new NhanVienDao().suaNhanVien(nv);
        if (checkUpdate) {
            System.out.println("Update successfully");
        } else {
            System.out.println("Update failed");
        }
    }
}