package com.example.item;

import com.example.item.zrExam.baiduIdCard.GsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {

    public static void main(String[] args) {
        String jsonObj = "{\"Root\":{\"Header\":{\"Response\":{\"Message\":\"成功\",\"Code\":\"0000\"},\"ExchangeId\":\"CQQYWX202112131418363212953064\"},\"QueryResults\":{\"Result\":{\"offerpackid\":\"20009741\",\"totalmessage\":\"0\",\"speedrule\":\"当月国内手机上网流量达到40GB时，将会降低上网速率，次月1日恢复。\",\"totalminu\":\"2000\",\"totaldownstrem\":\"0\",\"otherdesc\":\"手机含来电显示、189邮箱、可办4张副卡（可办理家庭V网实现主副卡本地互打不收费）；套内2GB流量最多可转换国内语音2000分钟或国内短信2000条；套餐含1路尊享版天翼高清；固定电话含300分钟国内通话；\",\"exceedtariff\":\"手机国内语音、流量、国内短信按0.0001元/KB收费，国内语音、国内短信均折成流量计费，流量转换标准：1MB流量等于1分钟语音等于1条短信。国内彩信0.1元/条。\",\"totalflow\":\"99999\",\"totalupstream\":\"0\",\"packrecord\":[{\"offermessage\":\"0\",\"offername\":\"宽带电视融合套餐(87元档-用于129、169套餐)【2018】\",\"offerflow\":\"0\",\"offerupstream\":\"0\",\"offermms\":\"0\",\"offerid\":\"10083710\",\"offerpresent\":\"\",\"membertype\":\"1\",\"offerfee\":\"0.00\",\"effdate\":\"2017-10-01 00:00:00\",\"offerminu\":\"0\",\"expdate\":\"2029-12-31 23:59:59\"},{\"offermessage\":\"0\",\"offername\":\"全家福畅享(169元)套餐关联包【2018】\",\"offerflow\":\"0\",\"offerupstream\":\"0\",\"offermms\":\"0\",\"offerid\":\"10088019\",\"offerpresent\":\"\",\"membertype\":\"1\",\"offerfee\":\"169.00\",\"effdate\":\"2017-10-01 00:00:00\",\"offerminu\":\"0\",\"expdate\":\"2029-12-31 23:59:59\"},{\"offermessage\":\"0\",\"offername\":\"全家福畅享40GB(169元)套餐【2018】\",\"offerflow\":\"99999\",\"offerupstream\":\"0\",\"offermms\":\"0\",\"offerid\":\"10087884\",\"offerpresent\":\"\",\"membertype\":\"1\",\"offerfee\":\"0.00\",\"effdate\":\"2017-10-01 00:00:00\",\"offerminu\":\"2000\",\"expdate\":\"2038-12-31 23:59:59\"},{\"offermessage\":\"0\",\"offername\":\"4G/5G业务V网销售品【2018】\",\"offerflow\":\"0\",\"offerupstream\":\"0\",\"offermms\":\"0\",\"offerid\":\"10051179\",\"offerpresent\":\"\",\"membertype\":\"2\",\"offerfee\":\"0.00\",\"effdate\":\"2016-05-02 10:09:53\",\"offerminu\":\"0\",\"expdate\":\"2030-01-01 00:00:00\"},{\"offermessage\":\"0\",\"offername\":\"全家福畅享套餐5元副卡功能费【2018】\",\"offerflow\":\"0\",\"offerupstream\":\"0\",\"offermms\":\"0\",\"offerid\":\"10087887\",\"offerpresent\":\"\",\"membertype\":\"2\",\"offerfee\":\"0.00\",\"effdate\":\"2017-10-01 00:00:00\",\"offerminu\":\"0\",\"expdate\":\"2038-12-31 23:59:59\"},{\"offermessage\":\"0\",\"offername\":\"全家福畅享套餐5元副卡功能费【2018】\",\"offerflow\":\"0\",\"offerupstream\":\"0\",\"offermms\":\"0\",\"offerid\":\"10087887\",\"offerpresent\":\"\",\"membertype\":\"2\",\"offerfee\":\"0.00\",\"effdate\":\"2017-10-01 00:00:00\",\"offerminu\":\"0\",\"expdate\":\"2038-12-31 23:59:59\"},{\"offermessage\":\"0\",\"offername\":\"全家福畅享套餐5元副卡功能费【2018】\",\"offerflow\":\"0\",\"offerupstream\":\"0\",\"offermms\":\"0\",\"offerid\":\"10087887\",\"offerpresent\":\"\",\"membertype\":\"2\",\"offerfee\":\"0.00\",\"effdate\":\"2017-10-01 00:00:00\",\"offerminu\":\"0\",\"expdate\":\"2038-12-31 23:59:59\"},{\"offermessage\":\"0\",\"offername\":\"全家福畅享副卡优惠【2018】\",\"offerflow\":\"0\",\"offerupstream\":\"0\",\"offermms\":\"0\",\"offerid\":\"10088288\",\"offerpresent\":\"\",\"membertype\":\"2\",\"offerfee\":\"0.00\",\"effdate\":\"2017-09-22 15:29:26\",\"offerminu\":\"0\",\"expdate\":\"2029-12-31 23:59:59\"},{\"offermessage\":\"0\",\"offername\":\"全家福畅享套餐5元副卡功能费【2018】\",\"offerflow\":\"0\",\"offerupstream\":\"0\",\"offermms\":\"0\",\"offerid\":\"10087887\",\"offerpresent\":\"\",\"membertype\":\"2\",\"offerfee\":\"0.00\",\"effdate\":\"2019-08-01 00:00:00\",\"offerminu\":\"0\",\"expdate\":\"2038-12-31 23:59:59\"}],\"offerpackname\":\"全家福畅享169元套餐\",\"offerBillingCycle\":\"\",\"totalfee\":\"169.00\",\"totalmms\":\"0\",\"packexpdate\":\"2029-12-31 23:59:59\",\"packeffdate\":\"2017-10-01 00:00:00\",\"transitiondesc\":\"\"}}}}";
        JsonObject json = JsonParser.parseString(jsonObj).getAsJsonObject().getAsJsonObject("Root");
        JsonElement resultObject = json.getAsJsonObject("QueryResults").getAsJsonArray("Result");
        System.out.println(resultObject);
        QueryOfferPackRsp queryOfferPackRsp = GsonUtils.fromJson(resultObject.toString(), QueryOfferPackRsp.class);
        System.out.println(queryOfferPackRsp.getOfferPackName());
    }
}