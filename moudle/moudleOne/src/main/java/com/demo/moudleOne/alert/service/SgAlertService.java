package com.demo.moudleOne.alert.service;

import com.demo.common.entity.SgAlert;
import com.demo.common.entity.SgDeviceFiles;
import com.demo.common.mapper.SgDeviceFilesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LXW
 * @date 2020/04/10 21:14
 */
@Service
public class SgAlertService {

    @Resource
    SgDeviceFilesMapper sgDeviceFilesMapper;

    public String sgAlert() {
        SgAlert alert = new SgAlert();
        alert.setDevSn("00000000000001");

        SgDeviceFiles deviceFiles = new SgDeviceFiles();
        deviceFiles.setDeviceNumber("00000000001设备");
//			deviceFiles.setDeviceName("0000000001设备");
//			deviceFiles.setDeviceType("01");
//			deviceFiles.setDeviceModel("T20");
//			deviceFiles.setDeviceFirm("厂商1");
//			deviceFiles.setBusinessSystem("03");
//			deviceFiles.setCommunicationType("无线");
//			deviceFiles.setCommunicationAgreement("无线规约");
//			deviceFiles.setCommunicationProtocal("无线协议");
//			deviceFiles.setTermCommteAddress("终端通信地址");
//			deviceFiles.setMasterAddressIp("127.0.0.1");
//			deviceFiles.setMasterPort("8080");
//			deviceFiles.setIsNewNorm("01");
//			deviceFiles.setImportTime(new Date());
//			deviceFiles.setDeviceAddress("地址");
//			deviceFiles.setProvince("北京市");
//			deviceFiles.setCity("北京市");
//			deviceFiles.setRegion("昌平区");
//			deviceFiles.setGdLatitude("100");
//			deviceFiles.setGdLongitude("99");
//			deviceFiles.setPrincipal("人");
//			deviceFiles.setTelephone("15234535678");
//			deviceFiles.setIsRegister("01");
//			deviceFiles.setRegisterTime(new Date());
//			deviceFiles.setRegisterUser("人柱力");
//			deviceFiles.setIsCancel("04");
//			deviceFiles.setIsIdentificat("05");
//			deviceFiles.setIdentificatTime(new Date());
//			deviceFiles.setIdentificaUser("认证人");
//			deviceFiles.setRightUnite("认证单位");
//			deviceFiles.setDetailAddress("asdfghjkkll");
        sgDeviceFilesMapper.insert(deviceFiles);
        return "sd告警" + alert.toString() + "/n" + deviceFiles.toString();
    }
}
