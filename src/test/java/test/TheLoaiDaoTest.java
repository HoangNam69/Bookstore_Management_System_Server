package test;

import dao.TheLoaiDao;
import entities.TheLoaiSach;
import entities.TheLoaiVanPhongPham;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TheLoaiDaoTest {
    private TheLoaiDao theLoaiDao;
    @BeforeAll
    void setUp()throws Exception {
        theLoaiDao = new TheLoaiDao();
    }


    @Test
    void testGetListTheLoai()throws Exception {
        List<TheLoaiSach> theLoaiSachList = theLoaiDao.getListTheLoaiSach();
        assertNotNull(theLoaiSachList);

    }

    @Test
    void testGetListTheLoaiVanPhongPham()throws Exception {
        List<TheLoaiSach> theLoaiSachList = theLoaiDao.getListTheLoaiSach();
        assertNotNull(theLoaiSachList);

    }

    @Test
    void testThemTheLoaiSach() throws Exception{
        TheLoaiSach theLoaiSach = new TheLoaiSach("TL9909", "The Loai 01");
        boolean result = theLoaiDao.themTheLoaiSach(theLoaiSach);
        assertNotNull(result);
    }


    @Test
    void testThemTheLoaiVanPhongPham() throws Exception{
        TheLoaiVanPhongPham theLoaiVanPhongPham = new TheLoaiVanPhongPham("VP9909", "The Loai 01");
        boolean result = theLoaiDao.themTheLoaiVanPhongPham(theLoaiVanPhongPham);
        assertNotNull(result);
    }


    @Test
    void testTimTheLoaiSach() throws Exception{
        TheLoaiSach theLoaiSach = theLoaiDao.timTheLoaiSach("The Loai 01");
        assertNotNull(theLoaiSach);
    }


    @Test
    void testTimTheLoaiVanPhongPham() throws Exception {
        TheLoaiVanPhongPham theLoaiVanPhongPham = theLoaiDao.timTheLoaiVanPhongPham("The Loai 01");
        assertNotNull(theLoaiVanPhongPham);
    }

    @Test
    void testGetSachTheoTheLoai() throws Exception{
        List<TheLoaiSach> theLoaiSachList = theLoaiDao.getSachTheoTheLoai("TL9909");
        assertNotNull(theLoaiSachList);
    }



    @Test
    void testKiemTraTonTaiTheLoaiVPP() throws Exception{
        boolean result = theLoaiDao.kiemTraTonTaiTheLoaiVPP("The Loai 01");
        assertNotNull(result);
    }


    @Test
    void testKiemTraTonTaiTheLoaiSach()throws Exception {
        boolean result = theLoaiDao.kiemTraTonTaiTheLoaiSach("The Loai 01");
        assertNotNull(result);
    }



    @AfterAll
    void tearDown() {
        theLoaiDao = null;
    }


}
