/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.HandlesFilesDao;

/**
 *
 * @author DELL
 */
public class HandlesFilesRepository implements Interfaces_HandlesFilesRepository{

    @Override
    public void find() {
        HandlesFilesDao.Instance().findPersonInfo();
    }

    @Override
    public void copy() {
        HandlesFilesDao.Instance().coppyNewFile();
    }
    
}
