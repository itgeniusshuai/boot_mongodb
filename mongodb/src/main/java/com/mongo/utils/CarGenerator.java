package com.mongo.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.mongo.document.CarDoc;

public class CarGenerator {

	public static CarDoc Generated(String id){
		Random random = new Random();
		Calendar now = Calendar.getInstance();
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		now.add(Calendar.HOUR, random.nextInt(1000));
		Date sessionTime = now.getTime();
		now.add(Calendar.MONTH, -random.nextInt(100));
		Date checkTime = now.getTime();
		now.add(Calendar.MONTH, +-random.nextInt(3));
		Date registerTime = now.getTime();
		CarDoc car = new CarDoc(id, carNames[random.nextInt(carNameSize)], random.nextInt(10000), 
				(long)random.nextInt(20), sessionTime, registerTime, checkTime, 
				random.nextInt(1000), random.nextInt(10000), random.nextInt(100000), 
				random.nextLong(), ""+(int)(random.nextDouble()*1000000), random.nextInt(5));
		return car;
	}
	
	private static String[] carNames = new String[]{
			"ALPINA/B4 BITURBO/2016款 3.0T 自动 B4 BITURBO Coupe"
			,"马自达/马自达6/2004款 2.3 自动 技术型"
			,"阿斯顿·马丁/Vanquish/2015款 6.0 自动 Coupe"
			,"阿尔法·罗密欧/156/2004款 2.0 自动"
			,"别克/凯越/2013款 1.5 手动 尊享型"
			,"安凯客车/宝斯通/2010款 2.2 手动 高级版HFC4GA2-1B"
			,"阿斯顿·马丁/Rapide/2016款 6.0 自动 Great Britain Edition"
			,"奥迪/100/1992款 2.0 手动"
			,"奥迪/A6L/2017款 2.5 自动 30FSI舒适型"
			,"广汽吉奥/猛将旅/2007款 2.2 手动 经济型"
			,"东风风度/风度MX5/2017款 2.0 自动 都市版"
			,"保时捷/Carrera-GT/2004款 5.7 手动 标准型"
			,"大迪/顺驰/2006款 2.2T 手动 豪华型 柴油"
			,"长城/精灵/2009款 1.3 手动 CORSS豪华型"
			,"阿斯顿·马丁/Virage Coupe/2012款 6.0 自动 龙年88中国限量版"
			,"北京/北京20/2016款 1.5T 自动 豪华型"
			,"北汽制造/雷驰/2005款 2.2 手动 标准型短轴四驱"
			,"别克/君威/2015款 2.0T 自动 GS豪情运动型"
			,"阿斯顿·马丁/V12 Vantage/2016款 6.0 自动 S Coupe"
			,"北京/北京80/2017款 2.8T 手动 豪华三门版 柴油"
			,"宝骏/730/2017款 1.5T 手动 豪华型"
			,"安凯客车/宝斯通/2014款 3.0T 手动 VIP版NGD3.0-C3HA"
			,"奔腾/X80/2017款 2.0 手动 舒适型"
			,"北京/北京80/2017款 2.8T 手动 豪华五门版 柴油"
			,"奔驰/E级/2017款 2.0T 自动 E200运动版四驱"
			,"阿斯顿·马丁/Vanquish/2015款 6.0 自动 Volante"
			,"别克/GL8/2017款 2.0T 自动 28T豪华型"
			,"北汽制造/战旗/2016款 2.0 手动 CK豪华型 国V"
			,"阿斯顿·马丁/V8 Vantage/2016款 4.7 自动"
			,"北汽制造/陆铃/2012款 2.8T 手动 标准型四驱"
			,"北京/北京20/2016款 1.5T 手动 精英型"
			,"阿尔法·罗密欧/166/2004款 2.0T 手动 Spark"
			,"安驰/威豹/2009款 2.0T 手动 柴油"
			,"北汽制造/御虎/2003款 2.2 手动 豪华型"
			,"奔驰/GLK级/2015款 2.0T 自动 GLK260动感型极致版"
			,"巴博斯/smart fortwo/2017款 0.9T 自动 硬顶BRABUS Xclusive"
			,"本田/锋范/2017款 1.5 自动 精英版"
			,"奔腾/X80/2017款 2.0 手动 基本型"
			,"宝马/2系旅行车/2016款 1.5T 自动 218i运动设计套装"
			,"宝龙/菱骏/2003款 2.4 手动 豪华型"
			,"布加迪/威航/2010款 8.0T 自动 16.4百年纪念版"
			,"帕加尼/Huayra/2016款 6.0T 自动 特别版"
			,"阿斯顿·马丁/V8 Vantage/2015款 4.7 自动"
			,"北汽幻速/H3/2017款 1.5 手动 舒适天窗版"
			,"奥迪/A4/2008款 1.8T 自动 个性风格版"
			,"标致/408/2016款 1.6T 自动 豪华型"
			,"别克/凯越/2015款 1.5 自动 尊享型"
			,"北京/北京40/2016款 2.0T 手动 尊贵版四驱"
			,"保时捷/Cayenne/2016款 3.0T 自动"
			,"别克/林荫大道/2010款 3.0 自动 旗舰型"
			,"阿尔法·罗密欧/Giulia/2017款 2.0T 自动 200HP豪华版"
			,"奥迪/A4/2008款 2.0T 自动 个性风格版"
			,"北京/E系列三厢/2013款 1.5 自动 乐尚版"
			,"阿斯顿·马丁/V12 Vantage/2016款 6.0 自动 S Roadster"
			,"别克/GL8/2017款 2.0T 自动 28T舒适型"
			,"别克/GL8/2017款 2.0T 自动 28T尊享型"
			,"别克/君威/2015款 2.0T 自动 GS纵情运动型"
			,"北汽制造/角斗士/2003款 2.0T 手动 柴油"
			,"奔驰/E级/2017款 2.0T 自动 E200运动版"
			,"北汽新能源/EX系列/2017款 纯电动 EX260乐酷版"
			,"宝骏/610/2014款 1.5 手动 舒适型"
			,"别克/GL8陆尊/2006款 3.0 自动 CT舒适型7座"
			,"宾利/雅骏/2009款 6.8T 自动"
			,"宝马/1系/2017款 2.0T 自动 120i设计套装型"
			,"北汽威旺/威旺T205-D/2013款 1.0 手动 加长版"
			,"别克/凯越/2015款 1.5 手动 尊享型"
			,"宝龙/菱麒/2003款 2.4 手动"
			,"宝骏/560/2017款 1.5T 手动 律动版尊享型"
			,"别克/荣御/2005款 2.8 自动 GL豪华型"
			,"奥迪/200/1999款 2.4 手动"
			,"保时捷/Cayenne/2016款 3.0T 自动 Platinum Edition"
			,"北汽制造/陆铃/2010款 2.2 手动 标准型高顶后驱"
			,"北京/北京40/2016款 2.0T 手动 尊贵版后驱"
			,"阿尔法·罗密欧/Giulia/2017款 2.0T 自动 200HP精英版"
			,"保时捷/911 敞篷车/2016款 3.8T 自动 Turbo四驱"
			,"斯柯达/晶锐/2011款 1.4 自动 晶致版"
	};
	private static int carNameSize = carNames.length;
	
}
