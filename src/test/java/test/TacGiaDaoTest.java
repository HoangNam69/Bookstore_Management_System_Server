package test;

import dao.TacGiaDao;
import entities.TacGia;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TacGiaDaoTest {
    private TacGiaDao tacGiaDao;

    @BeforeAll
    void setUp() throws Exception {
        tacGiaDao = new TacGiaDao();
    }

    @Test
    void testGetListTacGia() throws Exception{
        ArrayList<TacGia> list = (ArrayList<TacGia>) tacGiaDao.getListTacGia();
        for (TacGia tacGia : list) {
            assertNotNull(tacGia);
        }
        assertTrue(list.size() > 0);

    }

    @Test
    void testGetTacGia()throws Exception {
        ArrayList<TacGia> list = (ArrayList<TacGia>) tacGiaDao.getTacGia("TG001");
        for (TacGia tacGia : list) {
            assertNotNull(tacGia);
        }
        assertTrue(list.size() > 0);
    }

    @Test
    void testThemTacGia()throws Exception {
        TacGia tacGia = new TacGia("TG020", "Ha Huu Vinh");
        assertTrue(tacGiaDao.themTacGia(tacGia));
    }

    @Test
    void testXoaTacGia()throws Exception {
        assertTrue(tacGiaDao.xoaTacGia("TG020"));
    }

    @Test
    void timTacGia()throws Exception {
        TacGia tacGia = tacGiaDao.timTacGia("Ha Huu Vinh");
        assertNotNull(tacGia);
    }

    @Test
    void kiemTraTonTaiTacGia()throws Exception {
        assertTrue(tacGiaDao.kiemTraTonTaiTacGia("Ha Huu Vinh"));
    }

    @AfterAll
    void tearDown() {
        tacGiaDao = null;
    }


}
