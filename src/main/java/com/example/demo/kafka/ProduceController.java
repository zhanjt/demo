package com.example.demo.kafka;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/9  | 修改内容
 */
@RestController
@RequestMapping("/kafka")
public class ProduceController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    private String topicName = "demo-test";
    private String topicName = "TOPIC_COMMON_LOG";

    private final static String msg = "{\"SC_MARK\":\"MA_NM\",\"BIZ_MODE\":\"0x13\",\"REQUEST_TIME\":\"20210429153652880\",\"TABLE\":\"T_INTERFACE_OUT_LOG\",\"ERR_CODE\":\"I110013\",\"IP_PORT\":\"172.16.40.204:18600\",\"UUID\":\"9b4b95f04c5545fa8eb13bf01e92548d\",\"BSN\":\"45A12A9D0F24321630\",\"SERVICE_NAME\":\"ctid_download\",\"EXEC_TIME\":\"224\",\"RESPONSE_STR\":\"{\\\"sign\\\":\\\"MIICZgYKKoEcz1UGAQQCAqCCAlYwggJSAgEBMQ4wDAYIKoEcz1UBgxEFADAMBgoqgRzPVQYBBAIBoIIBfzCCAXswggEeoAMCAQICCCgsFnObILWAMAwGCCqBHM9VAYN1BQAwMTELMAkGA1UEBhMCQ04xETAPBgNVBAoTCEdMQ1RJRDAxMQ8wDQYDVQQDEwZHTENBMDEwHhcNMjAwNTA3MDEyMzA4WhcNMzAxMjI5MDEyMzA4WjBAMQswCQYDVQQGEwJDTjERMA8GA1UEChMIR0xDVElEMDExDTALBgNVBAsTBFNJR04xDzANBgNVBAMTBlJaRlcwMTBZMBMGByqGSM49AgEGCCqBHM9VAYItA0IABCUCkqJgvUH0H3PuV/UHgRXwXHZXvFSY/QjNHiQuPnpDaelTFOt0T+mdod4fERhfP1S7tLoVzUpaE3PxoILD4LqjDzANMAsGA1UdDwQEAwIGwDAMBggqgRzPVQGDdQUAA0kAMEYCIQCchfX57rkg2sLoKTul1FYnOjbz/F+Jf8K3j4Lv6Iy5swIhAMlbWg3+TOnsJfw/qLyXQpo0DUa0YZz5YFRkIjnWa55mMYGrMIGoAgEBMD0wMTELMAkGA1UEBhMCQ04xETAPBgNVBAoTCEdMQ1RJRDAxMQ8wDQYDVQQDEwZHTENBMDECCCgsFnObILWAMAwGCCqBHM9VAYMRBQAwDQYJKoEcz1UBgi0BBQAERzBFAiEAznyKcY8fa/EBzQMPGW3qIFiLWdKwGv+3s0HbLy92DEgCIESSuYXgDdF1hlAQ4u35U648C41BE8ZgSI7t+vqIQXPI\\\",\\\"bizPackage\\\":{\\\"authResultRetainData\\\":{\\\"result\\\":\\\"2\\\",\\\"ctidInfo\\\":\\\"\\\",\\\"ctidStatus\\\":\\\"2\\\",\\\"ctidIndex\\\":\\\"\\\",\\\"ctidName\\\":\\\"\\\"},\\\"timeStamp\\\":\\\"20210429153653090\\\",\\\"businessSerialNumber\\\":\\\"45A12A9D0F24321630\\\",\\\"errorDesc\\\":\\\"\\\",\\\"appName\\\":\\\"社保\\\",\\\"success\\\":true,\\\"authResult\\\":\\\"XXXX\\\",\\\"customNumber\\\":\\\"rzfw01\\\"}}\",\"BUSINESS_RESULT_CODE\":\"XXXX\",\"OUTSIDE_API_CALL_DESC\":\"{\\\"/interface/total/deciphering\\\":{\\\"cost_time\\\":2},\\\"http://172.16.40.185:8025/atom/license/flowLimitCountIncr\\\":{\\\"start_time\\\":\\\"20210429153653093\\\",\\\"responseResult\\\":{\\\"resultCode\\\":\\\"A000000\\\",\\\"bsn\\\":\\\"45A12A9D0F24321630\\\",\\\"resultDesc\\\":\\\"限流计数+1成功\\\"},\\\"cost_time\\\":\\\"11\\\",\\\"end_time\\\":\\\"20210429153653104\\\",\\\"resultCode\\\":\\\"A000000\\\",\\\"params\\\":{\\\"bizData\\\":{\\\"authMode\\\":\\\"0x13\\\",\\\"businessType\\\":\\\"2\\\",\\\"customerNo\\\":\\\"rzfw01\\\"},\\\"bsn\\\":\\\"45A12A9D0F24321630\\\"},\\\"bsn\\\":\\\"45A12A9D0F24321630\\\",\\\"resultDesc\\\":\\\"限流计数+1成功\\\"},\\\"/interface/id/deciphering\\\":{\\\"start_time\\\":\\\"20210429153652897\\\",\\\"cost_time\\\":1,\\\"end_time\\\":\\\"20210429153652898\\\"},\\\"http://172.16.40.161:19001/interface/bsn/check_bsn\\\":{\\\"start_time\\\":\\\"20210429153652880\\\",\\\"responseResult\\\":{\\\"resultCode\\\":\\\"I0000000\\\",\\\"resultDesc\\\":\\\"请求成功\\\",\\\"randomNum\\\":\\\"REE0QTdEMjYzQzk1RTUyMABLMEUCIQC7RYrO1MufcjviJnGxmA292pKY1DpcrqbDcoNbjOzRogIgMt1vw+bO6dVXKPu54FtpNDtWyU8z8NO395oAHAlS1uE=\\\"},\\\"cost_time\\\":\\\"4\\\",\\\"end_time\\\":\\\"20210429153652884\\\",\\\"resultCode\\\":\\\"I0000000\\\",\\\"params\\\":{\\\"authMode\\\":\\\"0x13\\\",\\\"bsn\\\":\\\"45A12A9D0F24321630\\\"},\\\"resultDesc\\\":\\\"请求成功\\\"},\\\"http://172.16.40.185:8025/atom/license/checkLicense\\\":{\\\"start_time\\\":\\\"20210429153652901\\\",\\\"responseResult\\\":{\\\"resultCode\\\":\\\"A000000\\\",\\\"bsn\\\":\\\"45A12A9D0F24321630\\\",\\\"resultDesc\\\":\\\"核验成功\\\"},\\\"cost_time\\\":\\\"5\\\",\\\"end_time\\\":\\\"20210429153652906\\\",\\\"resultCode\\\":\\\"A000000\\\",\\\"params\\\":{\\\"orgInfo\\\":{\\\"appId\\\":\\\"1381\\\",\\\"orgId\\\":\\\"00000001\\\"},\\\"bizData\\\":{\\\"authMode\\\":\\\"0x13\\\",\\\"system\\\":\\\"\\\",\\\"packageName\\\":\\\"com.bfxasi\\\",\\\"businessType\\\":\\\"2\\\",\\\"customerNo\\\":\\\"rzfw01\\\"},\\\"bsn\\\":\\\"45A12A9D0F24321630\\\"},\\\"bsn\\\":\\\"45A12A9D0F24321630\\\",\\\"resultDesc\\\":\\\"核验成功\\\"},\\\"http://172.16.40.185:8025/atom/license/flowLimitCount\\\":{\\\"start_time\\\":\\\"20210429153652885\\\",\\\"responseResult\\\":{\\\"resultCode\\\":\\\"A000000\\\",\\\"bsn\\\":\\\"45A12A9D0F24321630\\\",\\\"resultDesc\\\":\\\"限流通过\\\"},\\\"cost_time\\\":\\\"9\\\",\\\"end_time\\\":\\\"20210429153652894\\\",\\\"resultCode\\\":\\\"A000000\\\",\\\"params\\\":{\\\"bizData\\\":{\\\"authMode\\\":\\\"0x13\\\",\\\"limitMode\\\":\\\"1\\\",\\\"businessType\\\":\\\"2\\\",\\\"customerNo\\\":\\\"rzfw01\\\"},\\\"bsn\\\":\\\"45A12A9D0F24321630\\\"},\\\"bsn\\\":\\\"45A12A9D0F24321630\\\",\\\"resultDesc\\\":\\\"限流通过\\\"},\\\"/interface/photo/deciphering\\\":{\\\"start_time\\\":\\\"20210429153652897\\\",\\\"cost_time\\\":0,\\\"end_time\\\":\\\"20210429153652897\\\"},\\\"http://172.16.40.176:8023/biz/ctid_download/mode_0x13\\\":{\\\"start_time\\\":\\\"20210429153652906\\\",\\\"responseResult\\\":{\\\"data\\\":{\\\"retainAuthResult\\\":\\\"X\\\",\\\"ctid\\\":\\\"\\\",\\\"idExpireDate\\\":\\\"20220328\\\",\\\"textAuthResult\\\":\\\"X\\\",\\\"photoAuthResult\\\":\\\"X\\\",\\\"ctidAuthResult\\\":\\\"X\\\",\\\"ctidStatus\\\":\\\"2\\\"},\\\"resultCode\\\":\\\"B110023\\\",\\\"bsn\\\":\\\"45A12A9D0F24321630\\\",\\\"resultDesc\\\":\\\"网证已注销\\\"},\\\"cost_time\\\":\\\"179\\\",\\\"end_time\\\":\\\"20210429153653085\\\",\\\"resultCode\\\":\\\"B110023\\\",\\\"params\\\":{\\\"orgInfo\\\":{\\\"appId\\\":\\\"1381\\\",\\\"orgId\\\":\\\"00000001\\\"},\\\"bizData\\\":{\\\"photo1\\\":\\\"\\\",\\\"photo2\\\":\\\"\\\",\\\"livePhoto\\\":\\\"\\\",\\\"customerNo\\\":\\\"rzfw01\\\"},\\\"bsn\\\":\\\"45A12A9D0F24321630\\\",\\\"deviceInfo\\\":{\\\"phoneModel\\\":\\\"SPN-AL00\\\",\\\"phoneBrand\\\":\\\"HUAWEI\\\",\\\"deviceId\\\":\\\"4fc4e3fec904c584\\\"}},\\\"bsn\\\":\\\"45A12A9D0F24321630\\\",\\\"resultDesc\\\":\\\"网证已注销\\\"},\\\"http://172.16.40.161:19001/interface/bsn/save_data\\\":{\\\"start_time\\\":\\\"20210429153653085\\\",\\\"responseResult\\\":{\\\"resultCode\\\":\\\"I0000000\\\",\\\"resultDesc\\\":\\\"请求成功\\\"},\\\"cost_time\\\":\\\"5\\\",\\\"end_time\\\":\\\"20210429153653090\\\",\\\"resultCode\\\":\\\"I0000000\\\",\\\"params\\\":{\\\"bizData\\\":\\\"{\\\\\\\"phoneModel\\\\\\\":\\\\\\\"SPN-AL00\\\\\\\",\\\\\\\"idExpireDate\\\\\\\":\\\\\\\"20220328\\\\\\\",\\\\\\\"phoneBrand\\\\\\\":\\\\\\\"HUAWEI\\\\\\\",\\\\\\\"appId\\\\\\\":\\\\\\\"1381\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"周生宁\\\\\\\",\\\\\\\"mCode\\\\\\\":\\\\\\\"CC52EE2BD3BA9942111C703583D1B8A4652ED053584F2EC23A2DD344B17C59BE\\\\\\\",\\\\\\\"hashDn\\\\\\\":\\\\\\\"7531D3C0B54D57A65A87BE16D8399A99E0E0F2E7E128C47DF3585C4F9E893D35\\\\\\\",\\\\\\\"deviceId\\\\\\\":\\\\\\\"4fc4e3fec904c584\\\\\\\",\\\\\\\"idNo\\\\\\\":\\\\\\\"37082919910106593X\\\\\\\",\\\\\\\"orgId\\\\\\\":\\\\\\\"00000001\\\\\\\"}\\\",\\\"bsn\\\":\\\"45A12A9D0F24321630\\\"},\\\"resultDesc\\\":\\\"请求成功\\\"},\\\"/interface/retain_data/deciphering\\\":{\\\"start_time\\\":\\\"20210429153652898\\\",\\\"cost_time\\\":1,\\\"end_time\\\":\\\"20210429153652899\\\"},\\\"/interface/sign\\\":{\\\"start_time\\\":\\\"20210429153653090\\\",\\\"cost_time\\\":1,\\\"end_time\\\":\\\"20210429153653091\\\"},\\\"/interface/verify_sign\\\":{\\\"start_time\\\":\\\"20210429153652894\\\",\\\"cost_time\\\":2,\\\"end_time\\\":\\\"20210429153652896\\\"}}\",\"BIZ_TYPE\":\"ctid_download\",\"ERR_DESC\":\"网证已注销\",\"FUNCTION_NAME\":\"download\",\"REQUEST_STR\":\"{\\\"sign\\\":\\\"MIICZgYKKoEcz1UGAQQCAqCCAlYwggJSAgEBMQ4wDAYIKoEcz1UBgxEFADAMBgoqgRzPVQYBBAIB\\\\r\\\\noIIBfzCCAXswggEeoAMCAQICCCgsFnObILWAMAwGCCqBHM9VAYN1BQAwMTELMAkGA1UEBhMCQ04x\\\\r\\\\nETAPBgNVBAoTCEdMQ1RJRDAxMQ8wDQYDVQQDEwZHTENBMDEwHhcNMjAwNTA3MDEyMzA4WhcNMzAx\\\\r\\\\nMjI5MDEyMzA4WjBAMQswCQYDVQQGEwJDTjERMA8GA1UEChMIR0xDVElEMDExDTALBgNVBAsTBFNJ\\\\r\\\\nR04xDzANBgNVBAMTBlJaRlcwMTBZMBMGByqGSM49AgEGCCqBHM9VAYItA0IABCUCkqJgvUH0H3Pu\\\\r\\\\nV/UHgRXwXHZXvFSY/QjNHiQuPnpDaelTFOt0T+mdod4fERhfP1S7tLoVzUpaE3PxoILD4LqjDzAN\\\\r\\\\nMAsGA1UdDwQEAwIGwDAMBggqgRzPVQGDdQUAA0kAMEYCIQCchfX57rkg2sLoKTul1FYnOjbz/F+J\\\\r\\\\nf8K3j4Lv6Iy5swIhAMlbWg3+TOnsJfw/qLyXQpo0DUa0YZz5YFRkIjnWa55mMYGrMIGoAgEBMD0w\\\\r\\\\nMTELMAkGA1UEBhMCQ04xETAPBgNVBAoTCEdMQ1RJRDAxMQ8wDQYDVQQDEwZHTENBMDECCCgsFnOb\\\\r\\\\nILWAMAwGCCqBHM9VAYMRBQAwDQYJKoEcz1UBgi0BBQAERzBFAiBCkau8WqiIaZkjex53wsE/6oxt\\\\r\\\\niNlBRUGLeNisf9uBrgIhAJb66zw1isQWk6yKli0e8Cte41j7R8fs0+v2WO9b2VZG\\\",\\\"bizPackage\\\":{\\\"authMode\\\":\\\"0x13\\\",\\\"timeStamp\\\":\\\"20210429153652863\\\",\\\"businessSerialNumber\\\":\\\"45A12A9D0F24321630\\\",\\\"photoData\\\":\\\"\\\",\\\"authApplyRetainData\\\":\\\"MIIBVwYKKoEcz1UGAQQCA6CCAUcwggFDAgEAMYHSMIHPAgEAMD0wMTELMAkGA1UEBhMCQ04xETAP\\\\r\\\\nBgNVBAoTCEdMQ1RJRDAxMQ8wDQYDVQQDEwZHTENBMDECCF++xSx/G8lRMA0GCSqBHM9VAYItAwUA\\\\r\\\\nBHwwegIhAMlfLARfF0bXcgpiWYW8zt4v15rnvSQYfJTGm8OQM55eAiEA4yMPvk7SrZRDQN5DP9xN\\\\r\\\\nuOXRnI79Wig6rloLzlHpHwwEIDvCiNRhAQE+TdJwsvFCfyDSHbJ2rtmtzo7t/T75nKoABBDflZDc\\\\r\\\\nwcc8PLZTUQRpHpnQMGkGCiqBHM9VBgEEAgEwCQYHKoEcz1UBaIBQJQwE3VSnejie4guJ+3Cn1C+l\\\\r\\\\nO6SDwuSDUYZ+ltF4nift8dFns7aGirEwxegXzRQ20BDCkl+8m+7qJaytKaTUV3LKm4aPJNqpGTFb\\\\r\\\\nrCF5+3M=\\\",\\\"appName\\\":\\\"社保\\\",\\\"customNumber\\\":\\\"rzfw01\\\",\\\"idcardAuthData\\\":\\\"MIIB+QYKKoEcz1UGAQQCA6CCAekwggHlAgEAMYHRMIHOAgEAMD0wMTELMAkGA1UEBhMCQ04xETAPBgNVBAoTCEdMQ1RJRDAxMQ8wDQYDVQQDEwZHTENBMDECCF++xSx/G8lRMA0GCSqBHM9VAYItAwUABHsweQIhALKgGTuWJ2s1kXXb1mZOQPPWUgpNrHBLXS1GE5JoisZDAiAU+VCjSl/zkHmNs9v7Y27WGacZEJIsPmzzpyxXkN9tGgQg4WTr0B/LTnjSXwly1szwI/jlwiNLSog3aF3eSJ8wPdcEEE5WezICIA+kavL43YSsnF4wggEKBgoqgRzPVQYBBAIBMAkGByqBHM9VAWiAgfD3FUXGSXd641zXz+Wnl8zDiYQUdyn3LY2mWd4BdpLdxvFtRq8UBJAos7l6aSXY89idl6F+xZMYxw9LJY0C/vZaG2HCg8yXlYFCLRY4YNJwbXKsXf+r0MCrQcZwizk6shvylaaVAxl2ZMG0Huhtz7JSRmhuGyyFXaKM2SnaP4jzwsbCnOmt+y2OrVY5r3se7hzp6eWqxSw/KFewqFcZbrpL+fnZlTRWz5BXa1MLZr3ZSvT2ZDmDueDqZB+t7JFGyqLM5N+rsW7Cysig8yXcNB3GUoKDTaD+6b48I0WLZCChllqXnD9ttomyzgDyatijgxQ=\\\"}}\",\"SUCCESS_FLAG\":true,\"CUSTOMER_NO\":\"rzfw01\",\"RESPONSE_TIME\":\"20210429153653104\"}";

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    @GetMapping("/produce")
    public String produce(String str){
        JSONObject data = JSONObject.parseObject(msg);
        data.put("REQUEST_TIME", format.format(new Date()));
//        data.put("ERR_CODE","I110202");
        data.put("ERR_CODE","I110203");
        if(!StringUtils.isEmpty(str)){
            data.put("CUSTOMER_NO", str);
        }
//        data.put("spikeToken","token");
        for(int i = 0; i< 2; i++){
            if(i == 0){
                data.put("ERR_CODE","I110202");
            }else {
                data.put("ERR_CODE","I110203");
            }
            kafkaTemplate.send(topicName, null, data.toJSONString());
        }
        return "success";
    }


}
