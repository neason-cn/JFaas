package com.jfaas.example.service;

import java.net.URL;

import com.jfaas.container.core.FaasContainer;
import com.jfaas.container.impl.ArkFaasContainer;
import com.jfaas.core.bundle.impl.BundleInfoImpl;
import com.jfaas.domain.core.bundle.BundleInfo;

/**
 * @author : neason-cn
 * @date : 2021/10/29
 */
public class TestApplication {
    public static void main(String[] args) throws Exception {
        FaasContainer faasContainer = new ArkFaasContainer(args);
        URL url = new URL(
            "file:///resources/bundle-plugin.ark.plugin");
        BundleInfo<HelloService> bundleInfo = new BundleInfoImpl<>(url, HelloService.class);
        HelloService instance = faasContainer.load(bundleInfo).getInstance();
        System.out.println(instance.hello("jfaas"));
    }
}
