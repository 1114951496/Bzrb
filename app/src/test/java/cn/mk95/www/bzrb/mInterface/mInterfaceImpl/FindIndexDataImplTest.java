package cn.mk95.www.bzrb.mInterface.mInterfaceImpl;

import org.junit.Test;

import cn.mk95.www.bzrb.model.IndexPageOneDataEntity;
import cn.mk95.www.bzrb.model.IndexPageTwoDataEntity;


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
    @Test
    public void findIndexPageTwoData() {
        FindIndexDataImpl findIndexData=new FindIndexDataImpl();
        findIndexData.setFindIndexPageTwoListener(new FindIndexDataImpl.IndexPageTwoDataCallBack() {
            @Override
            public void indexPageTwoData(IndexPageTwoDataEntity indexPageTwoDataEntity) {

            }
        });
    }

}