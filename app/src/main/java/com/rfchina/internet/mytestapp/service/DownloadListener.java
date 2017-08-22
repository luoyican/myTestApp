package com.rfchina.internet.mytestapp.service;

/**
 * Created by luoyican on 2017/8/14.
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFail();

    void onPause();

    void onCancel();
}
