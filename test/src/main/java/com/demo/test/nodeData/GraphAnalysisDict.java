package com.demo.test.nodeData;

/**
 * 图谱分析字典类
 *
 * @author wang_jinglin
 *
 */
public class GraphAnalysisDict {

    /**
     * 获取各节点最新产生的前10条数据
     */
    public static final int topNum = 10;

    /**
     * 对应graph_analysis_task_config表中baseDataCode字段
     */
    public static final String alert = "alert";// 告警
    public static final String asset = "asset";// 资产
    public static final String monitor = "monitor";// 监控
    public static final String sysVulnCase = "sysVulnCase";// 脆弱性(漏扫)
    public static final String passwordCase = "passwordCase";// 脆弱性(弱口令)
    public static final String webWeakness = "webWeakness";// 脆弱性(web)
    public static final String vulnCvsCase = "vulnCvsCase";// 脆弱性(核查)

    // 对应的中文描述
    public static final String alertStr = "告警";
    public static final String assetStr = "资产";
    public static final String alertAndAssetStr = "告警和资产";
    public static final String monitorStr = "监控";
    public static final String sysVulnCaseStr = "漏扫";
    public static final String passwordCaseStr = "弱口令";
    public static final String webWeaknessStr = "web";
    public static final String vulnCvsCaseStr = "核查";


    // 数据来源中文描述
    public static final String logSourceStr = "日志";
    public static final String wxqbSourceStr = "威胁情报";
    public static final String ybwjSourceStr = "样本文件";
    // 数据来源英文描述
    public static final String logSourceEn = "log";// 日志
    public static final String wxqbSourceEn = "threatIntelligence";// 威胁情报
    public static final String ybwjSourceEn = "fileAnalysis";// 样本文件

    /**
     * 定义地址节点中属性为数据来源（dataSource）的枚举类型：
     * 告警
     * 资产（从监控中获取的也设置为资产）
     * 告警和资产（同时存在告警和资产数据中）
     */
    public static final String alertAndAsset = "alertAndAsset";// 告警和资产

    /**
     * 定义各节点的标签名称
     */
    public static final String LABEL_ADDRESS = "Address";// 地址节点
    public static final String LABEL_SERVICE = "Service";// 开放服务节点
    public static final String LABEL_ALERT = "Alert";// 告警节点
    public static final String LABEL_WEAKNESS = "Weakness";// 弱点节点
    public static final String LABEL_ATTACKER = "Attacker";// 攻击源节点
    public static final String LABEL_ALERTNAMETYPE = "AlertNameType";// 告警名称类型节点
    public static final String LABEL_YEAR = "Year";// 年节点
    public static final String LABEL_MONTH = "Month";// 月节点
    public static final String LABEL_DAY = "Day";// 日节点
    public static final String LABEL_HOUR = "Hour";// 时节点
    /**--------------------------------新增节点---------------------------------*/
    public static final String LABEL_FILEHASH = "FileHash";// 文件hash
    public static final String LABEL_LOGTYPE = "LogType";// 日志类型
    public static final String LABEL_INTELLIGENCETYPE = "IntelligenceType";// 情报类型
    public static final String LABEL_SAMPLEFILE = "SampleFile";// 样本文件

    /**
     * 查询neo4j时需过滤的节点类型
     */
    public static final String[] filterNodeTypes = {"Alert","Year","Month","Day","Hour"};
    /**
     * 查询前num数量的节点类型
     */
    public static final String[] topNumNodeTypes = {"Address","Service","AlertNameType","Weakness"};

    /**
     * 定义关系类型
     */
    public static final String EXIST_IN = "存在于";
    public static final String RUN_IN = "运行于";
    public static final String ATTACK_TO = "攻击";
    public static final String BELONG_TO = "属于";
    public static final String PRODUCE_TO = "产生于";
    public static final String HIT_TO = "命中";

}
