package cn.mk95.www.bzrb.mInterface.mInterfaceImpl;

import org.junit.Test;

import cn.mk95.www.bzrb.model.IndexPageOneDataEntity;


/**
 * Created by 11149 on 2017/6/7.
 */
public class FindIndexDataImplTest {
    @Test
    public void findIndexPageOneData() {
        FindIndexDataImpl findIndexData=new FindIndexDataImpl();
        findIndexData.setFindIndexPageOneListener(new FindIndexDataImpl.IndexDataCallBack() {
            @Override
            public void indexPageOneData(IndexPageOneDataEntity indexPageOneDataEntity) {

            }
        });
    }

}