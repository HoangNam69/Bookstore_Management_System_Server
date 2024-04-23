/**
 * @ (#) NhaCungCapDaoTest.java 1.0 21-Apr-24
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package test;

import dao.NhaCungCapDao;
import entities.NhaCungCap;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Le Hoang Nam
 * @date: 21-Apr-24
 * @version: 1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NhaCungCapDaoTest {
    private NhaCungCapDao nhaCungCapDao;

    @BeforeAll
    void setUp()throws Exception {
        nhaCungCapDao = new NhaCungCapDao();
    }

    @Test
    void testGetListNhaCungCapTheoLoaiSanPham()throws Exception {
        ArrayList<NhaCungCap> list = nhaCungCapDao.getListNhaCungCapTheoLoaiSanPham("Sách");
        for (NhaCungCap nhaCungCap : list) {
            assertNotNull(nhaCungCap);
        }
        assertTrue(list.size() > 0);
    }

    @Test
    void testGetListNhaCungCapTheoLoaiSanPhamKhongTonTai()throws Exception {
        ArrayList<NhaCungCap> list = nhaCungCapDao.getListNhaCungCapTheoLoaiSanPham("Sách Vui");
        for (NhaCungCap nhaCungCap : list) {
            assertNull(nhaCungCap);
        }
        assertFalse(list.size() > 0);
    }


    @Test
    void testGetAllListNhaCungCap() throws Exception{
        ArrayList<NhaCungCap> list = nhaCungCapDao.getAllListNhaCungCap();
        for (NhaCungCap nhaCungCap : list) {
            assertNotNull(nhaCungCap);
        }
        assertTrue(list.size() > 0);
    }

    @Test
    void testThemNhaCungCap() throws Exception{
        NhaCungCap ncc = new NhaCungCap("NCC009", "Le Hoang Son", "DQH-GV-HCM", "hoangSon@gmail.com", "0123456780");
        assertTrue(nhaCungCapDao.themNhaCungCap(ncc));
    }

    @Test
    void testThemNhaCungCapTrungMa() throws Exception{
        NhaCungCap ncc = new NhaCungCap("NCC009", "Le Hoang Son", "DQH-GV-HCM", "hoangSon@gmail.com", "0123456780");
        assertFalse(nhaCungCapDao.themNhaCungCap(ncc));
    }

    @Test
    void testThemNhaCungCapTrungEmail() throws Exception{
        NhaCungCap ncc = new NhaCungCap("NCC010", "Le Hoang Long", "DQH-GV-HCM", "hoangSon@gmail.com", "0123456745");
        assertFalse(nhaCungCapDao.themNhaCungCap(ncc));
    }

    @Test
    void testThemNhaCungCapTrungSDT() throws Exception{
        NhaCungCap ncc = new NhaCungCap("NCC011", "Le Hoang Son", "DQH-GV-HCM", "hoangSonSang@gmail.com", "0123456780");
        assertFalse(nhaCungCapDao.themNhaCungCap(ncc));
    }

    @Test
    void testTimNhaCungCapTheoTen() throws Exception {
        NhaCungCap ncc = nhaCungCapDao.timNhaCungCapTheoTen("Le Hoang Son");
        assertNotNull(ncc);
    }

    @Test
    void testTimNhaCungCapTheoTenKhongTonTai() throws Exception{
        NhaCungCap ncc = nhaCungCapDao.timNhaCungCapTheoTen("Le Vu");
        assertNull(ncc);
    }


    @AfterAll
    void tearDown() {
        nhaCungCapDao = null;
    }
}
