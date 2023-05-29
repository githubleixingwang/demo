package com.demo.test.filter.violation;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URLDecoder;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @className AppConfig
 * @description TODO 系统配置属性读取类 ( 读取配置文件中的属性并提供get方法用于获取属性值， 配置文件路径：安装路径/Conf/appConfig.properties)
 * @author WangTianLang
 * @date 2021/5/10
 */
@Slf4j
public class AppConfig {

    // 系统配置 文件路径 文件名称
    private static final String APP_CONFIG_FILE_NAME = "filter/appConfig.properties";
    // AppConfig实例
    private static final AppConfig INSTANCE = new AppConfig();
    // 系统配置属性
    private Properties appConfigProperties = new Properties();
    // 系统运行模式
    private static final String SYS_RUN_MDOEL = "system_run_model";
    //系统运行参数
    private  final ConcurrentHashMap<String, Object> RUN_PARAM = new ConcurrentHashMap<>();


    /**
     * @description TODO 私有化构造方法
     * @param
     * @return
     * @author WangTianLiang
     * @date 2021/5/10
     */
    private AppConfig() {
        //加载配置文件
        loadAppConfigFile(APP_CONFIG_FILE_NAME);
    }


    /**
     * @description TODO 加载系统配置文件，配置文件路径在为“安装路径/config/appConfig.properties”
     * @param name 加载配置文件名称
     * @return void
     * @author WangTianLiang
     * @date 2021/5/10
     */
    private void loadAppConfigFile(String name) {
        //拼接配置文件名称
        String cfgFilePath = getAppInstallPath().concat(name);
        //创建输入流对象
        InputStream inStream = null;
        try {
            //读取文件
            inStream = new FileInputStream(cfgFilePath);
        } catch (FileNotFoundException e) {
            log.error("读取文件失败！",e);
            System.exit(-1);
        }
        try {
            if (inStream != null) {
                //将输入流转为文件对象
                appConfigProperties.load(inStream);
                if(appConfigProperties.size() <= 0) {
                    log.error("加载APPConfig配置文件失败，缺失必要运行时参数程序无法启动，正在退出!!");
                    System.exit(-1);
                }
                //获取当前系统的运行是模式
                String sys_run_model = appConfigProperties.getProperty(SYS_RUN_MDOEL).trim();
                RUN_PARAM.put(SYS_RUN_MDOEL, sys_run_model);
                //遍历所有参数生成符合真实运行时参数的MAP
                for(Entry<Object, Object> entry : appConfigProperties.entrySet()) {
                    String key = entry.getKey().toString().trim();
                    int run_model_index = key.indexOf(sys_run_model);
                    if(run_model_index  <= -1){
                        continue;
                    }
                    RUN_PARAM.put(key.replace(sys_run_model,""), entry.getValue());
                }
            }
        } catch (Exception e) {
            log.error("加载APPConfig配置文件失败，缺失必要运行时参数程序无法启动，正在退出~!~~!",e);
            System.exit(-1);
        }
    }


    /**
     * @description TODO 获取当前类路径
     * @param
     * @return java.lang.String
     * @author WangTianLiang
     * @date 2021/5/10
     */
    private static String getAppInstallPath() {
        // 获取获取安装路径
        String path = AppConfig.class.getResource("/").getPath();
        try {
            // 转码将中文16进制编码转换为中文
            path = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 去除路径前边的“/”
        File file = new File(path);
        String installPath = file.getPath().concat(File.separator);

        return installPath;
    }


    /**
     * @description TODO 获取运行时参数-当前参数根据系统运行模式变动
     * @param key appConfig.properties中配置的key
     * @return java.lang.Object
     * @author WangTianLiang
     * @date 2021/5/10
     */
    public static Object getSystemRunProperty(String key) {
        return  INSTANCE.RUN_PARAM.get(key);
    }


    /**
     * @description TODO 获取系统运行模式。 run_test_:测试模式；run_produce_:生产模式
     * @param
     * @return java.lang.Object
     * @author WangTianLiang
     * @date 2021/5/10
     */
    public static Object getSystemRunModel() {
        return  INSTANCE.RUN_PARAM.get(SYS_RUN_MDOEL);
    }

    /**
     * 测试用例
     */
    public static void main(String[] args){
        String wx_pub_appid = AppConfig.getSystemRunProperty("wx_pub_appid").toString();
        System.out.println(wx_pub_appid);
    }
}


