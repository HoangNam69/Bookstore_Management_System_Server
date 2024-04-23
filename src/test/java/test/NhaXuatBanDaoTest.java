/**
 * @ (#) NhaXuatBanDaoTest.java 1.0 21-Apr-24
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package test;

import dao.NhaXuatBanDao;
import entities.NhaXuatBan;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: Le Hoang Nam
 * @date: 21-Apr-24
 * @version: 1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NhaXuatBanDaoTest {
    private NhaXuatBanDao nhaXuatBanDao;

    @BeforeAll
    void setUp()throws Exception {
        nhaXuatBanDao = new NhaXuatBanDao();
    }

    @Test
    void testGetListNhaXuatBan()throws Exception {
        List<NhaXuatBan> list = nhaXuatBanDao.getListNhaXuatBan();
        for (NhaXuatBan nhaXuatBan : list) {
            assertNotNull(nhaXuatBan);
        }
        assertTrue(list.size() > 0);
    }

    @Test
    void testThemNhaXuatBan() throws Exception{
        NhaXuatBan nxb = new NhaXuatBan("NXB006", "NXB Bèo");
        assertTrue(nhaXuatBanDao.themNhaXuatBan(nxb));
    }

    @Test
    void testThemNhaXuatBanTrungMa() throws Exception{
        NhaXuatBan nxb = new NhaXuatBan("NXB006", "NXB Bèo");
        assertFalse(nhaXuatBanDao.themNhaXuatBan(nxb));
    }

    @Test
    void testThemNhaXuatBanTrungTen() throws Exception{
        NhaXuatBan nxb = new NhaXuatBan("NXB007", "NXB Bèo");
        assertFalse(nhaXuatBanDao.themNhaXuatBan(nxb));
    }

    @Test
    void testTimNhaXuatBan() throws Exception{
        NhaXuatBan nxb = nhaXuatBanDao.timNhaXuatBan("Nhà xuất bản Tuổi Trẻ");
        assertNotNull(nxb);
    }

    @Test
    void testTimNhaXuatBanKhongTonTai() throws Exception{
        NhaXuatBan nxb = nhaXuatBanDao.timNhaXuatBan("Nhà xuất bản Thời Xuân");
        assertNull(nxb);
    }

    @AfterAll
    void tearDown() {
        nhaXuatBanDao = null;
    }

}
