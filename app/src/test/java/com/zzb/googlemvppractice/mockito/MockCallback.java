package com.zzb.googlemvppractice.mockito;

import com.zzb.googlemvppractice.mockito.Api.Callback;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

/**
 * Created by ZZB on 2016/10/17.
 */

public class MockCallback {

    FollowModel mFollowModel;

    @Test
    public void test_mock_onSuccess() {
        mFollowModel = new FollowModel();
        Api mockApi = mock(Api.class);
        mFollowModel.mApi = mockApi;
        mockRequestSuccess(mockApi);
        mFollowModel.followSomebody(111);
        Assert.assertEquals(Long.valueOf(111), mFollowModel.followUids.get(0));
    }
    @Test
    public void test_mock_onFailed(){
        mFollowModel = new FollowModel();
        Api mockApi = mock(Api.class);
        mFollowModel.mApi = mockApi;
        mockRequestFailed(mockApi);
        mFollowModel.followSomebody(111);
        Assert.assertEquals(0, mFollowModel.followUids.size());
    }
    private void mockRequestSuccess(Api mockApi) {
        mockRequest(mockApi, true);
    }

    private void mockRequestFailed(Api mockApi) {
        mockRequest(mockApi, false);
    }

    private void mockRequest(Api mockApi, final boolean mockSuccess) {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                System.out.println("do answer, arg length: " + invocation.getArguments().length);
                Callback callback = (Callback) invocation.getArguments()[1];
                if (mockSuccess) {
                    callback.onSuccess("mock success");
                } else {
                    callback.onFailed("mock failed");
                }
                return null;
            }
        }).when(mockApi).request(anyString(), any(Callback.class));
    }
}

class FollowModel {
    Api mApi;
    List<Long> followUids = new ArrayList<>();

    public void followSomebody(final long uid) {
        System.out.println("starting follow somebody");
        mApi.request("followSomebody", new Callback() {
            @Override
            public void onSuccess(String msg) {
                System.out.println("follow somebody success");
                followUids.add(uid);
            }

            @Override
            public void onFailed(String msg) {
                System.out.println("follow somebody failed");
            }
        });
    }
}

class Api {

    public void request(String url, Callback callback) {
        System.out.println("real request");
        if (url != null) {
            callback.onSuccess(url);
        } else {
            callback.onFailed("request failed");
        }
    }

    interface Callback {
        void onSuccess(String msg);

        void onFailed(String msg);
    }

}
