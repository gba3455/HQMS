package edc2010.test;

import java.util.HashMap;
import java.util.Map;

public class Patient {
	String P900 = null;
	String P6891 = null;
	String P686 = null;
	String P800 = null;
	String P1 = null;
	String P2 = null;
	String P3 = null;
	String P4 = null;
	String P5 = null;
	String P6 = null;
	String P7 = null;
	String P8 = null;
	String P9 = null;
	String P101 = null;
	String P102 = null;
	String P103 = null;
	String P11 = null;
	String P12 = null;
	String P13 = null;
	String P801 = null;
	String P802 = null;
	String P803 = null;
	String P14 = null;
	String P15 = null;
	String P16 = null;
	String P17 = null;
	String P171 = null;
	String P18 = null;
	String P19 = null;
	String P20 = null;
	String P804 = null;
	String P21 = null;
	String P22 = null;
	String P23 = null;
	String P231 = null;
	String P24 = null;
	String P25 = null;
	String P26 = null;
	String P261 = null;
	String P27 = null;
	String P28 = null;
	String P281 = null;
	String P29 = null;
	String P30 = null;
	String P301 = null;
	String P31 = null;
	String P689 = null;
	String P351 = null;
	String P352 = null;
	String P816 = null;
	String P353 = null;
	String P354 = null;
	String P817 = null;
	String P355 = null;
	String P356 = null;
	String P818 = null;
	String P361 = null;
	String P362 = null;
	String P363 = null;
	String P364 = null;
	String P365 = null;
	String P366 = null;
	String P371 = null;
	String P372 = null;
	String P38 = null;
	String P39 = null;
	String P40 = null;
	String P411 = null;
	String P412 = null;
	String P413 = null;
	String P414 = null;
	String P415 = null;
	String P421 = null;
	String P422 = null;
	String P687 = null;
	String P688 = null;
	String P431 = null;
	String P432 = null;
	String P433 = null;
	String P434 = null;
	String P819 = null;
	String P435 = null;
	String P436 = null;
	String P437 = null;
	String P438 = null;
	String P44 = null;
	String P45 = null;
	String P46 = null;
	String P47 = null;
	String P561 = null;
	String P562 = null;
	String P563 = null;
	String P564 = null;
	String P6911 = null;
	String P6912 = null;
	String P6913 = null;
	String P6914 = null;
	String P6915 = null;
	String P6916 = null;
	String P6917 = null;
	String P6918 = null;
	String P6919 = null;
	String P6920 = null;
	String P6921 = null;
	String P6922 = null;
	String P6923 = null;
	String P6924 = null;
	String P6925 = null;
	String P57 = null;
	String P58 = null;
	String P581 = null;
	String P60 = null;
	String P611 = null;
	String P612 = null;
	String P613 = null;
	String P59 = null;
	String P62 = null;
	String P63 = null;
	String P64 = null;
	String P651 = null;
	String P652 = null;
	String P653 = null;
	String P654 = null;
	String P655 = null;
	String P656 = null;
	String P66 = null;
	String P681 = null;
	String P682 = null;
	String P683 = null;
	String P684 = null;
	String P685 = null;
	String P67 = null;
	String P731 = null;
	String P732 = null;
	String P733 = null;
	String P734 = null;
	String P72 = null;
	String P830 = null;
	String P831 = null;
	String P741 = null;
	String P742 = null;
	String P743 = null;
	String P782 = null;
	String P751 = null;
	String P752 = null;
	String P754 = null;
	String P755 = null;
	String P756 = null;
	String P757 = null;
	String P758 = null;
	String P759 = null;
	String P760 = null;
	String P761 = null;
	String P762 = null;
	String P763 = null;
	String P764 = null;
	String P765 = null;
	String P767 = null;
	String P768 = null;
	String P769 = null;
	String P770 = null;
	String P771 = null;
	String P772 = null;
	String P773 = null;
	String P774 = null;
	String P775 = null;
	String P776 = null;
	String P777 = null;
	String P778 = null;
	String P779 = null;
	String P780 = null;
	String P781 = null;
	String[] bigint_flag = {"P2","P7","P27","P689","P421","P422","P494","P4915","P4526","P4537","P4548","p45006","p45018","p45030","p45042","p45054","P561","P562","P563","P564","P611","P612","P613","P651","P652","P653","P654","P655","P656","P66","P681","P682","P683","P684","P685","P67","P731","P732","P733","P734","P72","P782","P751","P752","P754","P755","P756","P757","P758","P759","P760","P761","P762","P763","P764","P765","P767","P768","P769","P770","P771","P772","P773","P774","P775","P776","P777","P778","P779","P780","P781"};
	private static Map<String, Integer> lenth_map = null;

	public String[] getBigint_flag() {
		return this.bigint_flag;
	}	
	
    private static final Map<String, String> columnMap;
    // Create Diagnose Class
    class P_Diagnose {
    	String P321 = null;
    	String P322 = null;
    	String P805 = null;
    	String P323 = null;
    	String P324 = null;
    	String P325 = null;
    	String P806 = null;
    	String P326 = null;
    	String P327 = null;
    	String P328 = null;
    	String P807 = null;
    	String P329 = null;
    	String P3291 = null;
    	String P3292 = null;
    	String P808 = null;
    	String P3293 = null;
    	String P3294 = null;
    	String P3295 = null;
    	String P809 = null;
    	String P3296 = null;
    	String P3297 = null;
    	String P3298 = null;
    	String P810 = null;
    	String P3299 = null;
    	String P3281 = null;
    	String P3282 = null;
    	String P811 = null;
    	String P3283 = null;
    	String P3284 = null;
    	String P3285 = null;
    	String P812 = null;
    	String P3286 = null;
    	String P3287 = null;
    	String P3288 = null;
    	String P813 = null;
    	String P3289 = null;
    	String P3271 = null;
    	String P3272 = null;
    	String P814 = null;
    	String P3273 = null;
    	String P3274 = null;
    	String P3275 = null;
    	String P815 = null;
		String P3276 = null;
		String[][] diag_flag = {
    			{"P321","P322","P805","P323"},
    			{"P324","P325","P806","P326"},
    			{"P327","P328","P807","P329"},
    			{"P3291","P3292","P808","P3293"},
    			{"P3294","P3295","P809","P3296"},
    			{"P3297","P3298","P810","P3299"},
    			{"P3281","P3282","P811","P3283"},
    			{"P3284","P3285","P812","P3286"},
    			{"P3287","P3288","P813","P3289"},
    			{"P3271","P3272","P814","P3273"},
    			{"P3274","P3275","P815","P3276"},
    			};
    	public String[][] getDiag_flag() {
    		return this.diag_flag;
    	}
		 public String getP321() {
		    	return P321;
		    }
		    public String getP322() {
		    	return this.P322;
		    }
		    public String getP805() {
		    	return this.P805;
		    }
		    public String getP323() {
		    	return this.P323;
		    }
		    public String getP324() {
		    	return this.P324;
		    }
		    public String getP325() {
		    	return this.P325;
		    }
		    public String getP806() {
		    	return this.P806;
		    }
		    public String getP326() {
		    	return this.P326;
		    }
		    public String getP327() {
		    	return this.P327;
		    }
		    public String getP328() {
		    	return this.P328;
		    }
		    public String getP807() {
		    	return this.P807;
		    }
		    public String getP329() {
		    	return this.P329;
		    }
		    public String getP3291() {
		    	return this.P3291;
		    }
		    public String getP3292() {
		    	return this.P3292;
		    }
		    public String getP808() {
		    	return this.P808;
		    }
		    public String getP3293() {
		    	return this.P3293;
		    }
		    public String getP3294() {
		    	return this.P3294;
		    }
		    public String getP3295() {
		    	return this.P3295;
		    }
		    public String getP809() {
		    	return this.P809;
		    }
		    public String getP3296() {
		    	return this.P3296;
		    }
		    public String getP3297() {
		    	return this.P3297;
		    }
		    public String getP3298() {
		    	return this.P3298;
		    }
		    public String getP810() {
		    	return this.P810;
		    }
		    public String getP3299() {
		    	return this.P3299;
		    }
		    public String getP3281() {
		    	return this.P3281;
		    }
		    public String getP3282() {
		    	return this.P3282;
		    }
		    public String getP811() {
		    	return this.P811;
		    }
		    public String getP3283() {
		    	return this.P3283;
		    }
		    public String getP3284() {
		    	return this.P3284;
		    }
		    public String getP3285() {
		    	return this.P3285;
		    }
		    public String getP812() {
		    	return this.P812;
		    }
		    public String getP3286() {
		    	return this.P3286;
		    }
		    public String getP3287() {
		    	return this.P3287;
		    }
		    public String getP3288() {
		    	return this.P3288;
		    }
		    public String getP813() {
		    	return this.P813;
		    }
		    public String getP3289() {
		    	return this.P3289;
		    }
		    public String getP3271() {
		    	return this.P3271;
		    }
		    public String getP3272() {
		    	return this.P3272;
		    }
		    public String getP814() {
		    	return this.P814;
		    }
		    public String getP3273() {
		    	return this.P3273;
		    }
		    public String getP3274() {
		    	return this.P3274;
		    }
		    public String getP3275() {
		    	return this.P3275;
		    }
		    public String getP815() {
		    	return this.P815;
		    }
		    public String getP3276() {
		    	return this.P3276;
		    }
		    public void setP321(String P321) {
		    	this.P321 = P321;
		    }
		    public void setP322(String P322) {
		    	this.P322 = P322;
		    }
		    public void setP805(String P805) {
		    	this.P805 = P805;
		    }
		    public void setP323(String P323) {
		    	this.P323 = P323;
		    }
		    public void setP324(String P324) {
		    	this.P324 = P324;
		    }
		    public void setP325(String P325) {
		    	this.P325 = P325;
		    }
		    public void setP806(String P806) {
		    	this.P806 = P806;
		    }
		    public void setP326(String P326) {
		    	this.P326 = P326;
		    }
		    public void setP327(String P327) {
		    	this.P327 = P327;
		    }
		    public void setP328(String P328) {
		    	this.P328 = P328;
		    }
		    public void setP807(String P807) {
		    	this.P807 = P807;
		    }
		    public void setP329(String P329) {
		    	this.P329 = P329;
		    }
		    public void setP3291(String P3291) {
		    	this.P3291 = P3291;
		    }
		    public void setP3292(String P3292) {
		    	this.P3292 = P3292;
		    }
		    public void setP808(String P808) {
		    	this.P808 = P808;
		    }
		    public void setP3293(String P3293) {
		    	this.P3293 = P3293;
		    }
		    public void setP3294(String P3294) {
		    	this.P3294 = P3294;
		    }
		    public void setP3295(String P3295) {
		    	this.P3295 = P3295;
		    }
		    public void setP809(String P809) {
		    	this.P809 = P809;
		    }
		    public void setP3296(String P3296) {
		    	this.P3296 = P3296;
		    }
		    public void setP3297(String P3297) {
		    	this.P3297 = P3297;
		    }
		    public void setP3298(String P3298) {
		    	this.P3298 = P3298;
		    }
		    public void setP810(String P810) {
		    	this.P810 = P810;
		    }
		    public void setP3299(String P3299) {
		    	this.P3299 = P3299;
		    }
		    public void setP3281(String P3281) {
		    	this.P3281 = P3281;
		    }
		    public void setP3282(String P3282) {
		    	this.P3282 = P3282;
		    }
		    public void setP811(String P811) {
		    	this.P811 = P811;
		    }
		    public void setP3283(String P3283) {
		    	this.P3283 = P3283;
		    }
		    public void setP3284(String P3284) {
		    	this.P3284 = P3284;
		    }
		    public void setP3285(String P3285) {
		    	this.P3285 = P3285;
		    }
		    public void setP812(String P812) {
		    	this.P812 = P812;
		    }
		    public void setP3286(String P3286) {
		    	this.P3286 = P3286;
		    }
		    public void setP3287(String P3287) {
		    	this.P3287 = P3287;
		    }
		    public void setP3288(String P3288) {
		    	this.P3288 = P3288;
		    }
		    public void setP813(String P813) {
		    	this.P813 = P813;
		    }
		    public void setP3289(String P3289) {
		    	this.P3289 = P3289;
		    }
		    public void setP3271(String P3271) {
		    	this.P3271 = P3271;
		    }
		    public void setP3272(String P3272) {
		    	this.P3272 = P3272;
		    }
		    public void setP814(String P814) {
		    	this.P814 = P814;
		    }
		    public void setP3273(String P3273) {
		    	this.P3273 = P3273;
		    }
		    public void setP3274(String P3274) {
		    	this.P3274 = P3274;
		    }
		    public void setP3275(String P3275) {
		    	this.P3275 = P3275;
		    }
		    public void setP815(String P815) {
		    	this.P815 = P815;
		    }
		    public void setP3276(String P3276) {
		    	this.P3276 = P3276;
		    }
    	public P_Diagnose() {
    	}
    	
    	public void reset_diagnose() {

        	P321 = null;
        	P322 = null;
        	P805 = null;
        	P323 = null;
        	P324 = null;
        	P325 = null;
        	P806 = null;
        	P326 = null;
        	P327 = null;
        	P328 = null;
        	P807 = null;
        	P329 = null;
        	P3291 = null;
        	P3292 = null;
        	P808 = null;
        	P3293 = null;
        	P3294 = null;
        	P3295 = null;
        	P809 = null;
        	P3296 = null;
        	P3297 = null;
        	P3298 = null;
        	P810 = null;
        	P3299 = null;
        	P3281 = null;
        	P3282 = null;
        	P811 = null;
        	P3283 = null;
        	P3284 = null;
        	P3285 = null;
        	P812 = null;
        	P3286 = null;
        	P3287 = null;
        	P3288 = null;
        	P813 = null;
        	P3289 = null;
        	P3271 = null;
        	P3272 = null;
        	P814 = null;
        	P3273 = null;
        	P3274 = null;
        	P3275 = null;
        	P815 = null;
        	P3276 = null;
    	}
    	
    }
    // Create Operation Class
    class P_Operation {
    	String P490 = null;
    	String P491 = null;
    	String P820 = null;
    	String P492 = null;
    	String P493 = null;
    	String P494 = null;
    	String P495 = null;
    	String P496 = null;
    	String P497 = null;
    	String P498 = null;
    	String P4981 = null;
    	String P499 = null;
    	String P4910 = null;
    	String P4911 = null;
    	String P4912 = null;
    	String P821 = null;
    	String P4913 = null;
    	String P4914 = null;
    	String P4915 = null;
    	String P4916 = null;
    	String P4917 = null;
    	String P4918 = null;
    	String P4919 = null;
    	String P4982 = null;
    	String P4920 = null;
    	String P4921 = null;
    	String P4922 = null;
    	String P4923 = null;
    	String P822 = null;
    	String P4924 = null;
    	String P4925 = null;
    	String P4526 = null;
    	String P4527 = null;
    	String P4528 = null;
    	String P4529 = null;
    	String P4530 = null;
    	String P4983 = null;
    	String P4531 = null;
    	String P4532 = null;
    	String P4533 = null;
    	String P4534 = null;
    	String P823 = null;
    	String P4535 = null;
    	String P4536 = null;
    	String P4537 = null;
    	String P4538 = null;
    	String P4539 = null;
    	String P4540 = null;
    	String P4541 = null;
    	String P4984 = null;
    	String P4542 = null;
    	String P4543 = null;
    	String P4544 = null;
    	String P4545 = null;
    	String P824 = null;
    	String P4546 = null;
    	String P4547 = null;
    	String P4548 = null;
    	String P4549 = null;
    	String P4550 = null;
    	String P4551 = null;
    	String P4552 = null;
    	String P4985 = null;
    	String P4553 = null;
    	String P4554 = null;
    	String P45002 = null;
    	String P45003 = null;
    	String P825 = null;
    	String p45004 = null;
    	String p45005 = null;
    	String p45006 = null;
    	String p45007 = null;
    	String p45008 = null;
    	String p45009 = null;
    	String p45010 = null;
    	String p45011 = null;
    	String p45012 = null;
    	String p45013 = null;
    	String p45014 = null;
    	String p45015 = null;
    	String P826 = null;
    	String p45016 = null;
    	String p45017 = null;
    	String p45018 = null;
    	String p45019 = null;
    	String p45020 = null;
    	String p45021 = null;
    	String p45022 = null;
    	String p45023 = null;
    	String p45024 = null;
    	String p45025 = null;
    	String p45026 = null;
    	String p45027 = null;
    	String P827 = null;
    	String p45028 = null;
    	String p45029 = null;
    	String p45030 = null;
    	String p45031 = null;
    	String p45032 = null;
    	String p45033 = null;
    	String p45034 = null;
    	String p45035 = null;
    	String p45036 = null;
    	String p45037 = null;
    	String p45038 = null;
    	String p45039 = null;
    	String P828 = null;
    	String p45040 = null;
    	String p45041 = null;
    	String p45042 = null;
    	String p45043 = null;
    	String p45044 = null;
    	String p45045 = null;
    	String p45046 = null;
    	String p45047 = null;
    	String p45048 = null;
    	String p45049 = null;
    	String p45050 = null;
    	String p45051 = null;
    	String P829 = null;
    	String p45052 = null;
    	String p45053 = null;
    	String p45054 = null;
    	String p45055 = null;
    	String p45056 = null;
    	String p45057 = null;
    	String p45058 = null;
    	String p45059 = null;
    	String p45060 = null;
    	String p45061 = null;
    	String[][] oper_flag = {
    			{"P490","P491","P820","P492","P493","P494","P495","P496","P497","P498","P4981","P499","P4910"},
    			{"P4911","P4912","P821","P4913","P4914","P4915","P4916","P4917","P4918","P4919","P4982","P4920","P4921"},
    			{"P4922","P4923","P822","P4924","P4925","P4526","P4527","P4528","P4529","P4530","P4983","P4531","P4532"},
    			{"P4533","P4534","P823","P4535","P4536","P4537","P4538","P4539","P4540","P4541","P4984","P4542","P4543"},
    			{"P4544","P4545","P824","P4546","P4547","P4548","P4549","P4550","P4551","P4552","P4985","P4553","P4554"},
    			{"P45002","P45003","P825","p45004","p45005","p45006","p45007","p45008","p45009","p45010","p45011","p45012","p45013"},
    			{"p45014","p45015","P826","p45016","p45017","p45018","p45019","p45020","p45021","p45022","p45023","p45024","p45025"},
    			{"p45026","p45027","P827","p45028","p45029","p45030","p45031","p45032","p45033","p45034","p45035","p45036","p45037"},
    			{"p45038","p45039","P828","p45040","p45041","p45042","p45043","p45044","p45045","p45046","p45047","p45048","p45049"},
    			{"p45050","p45051","P829","p45052","p45053","p45054","p45055","p45056","p45057","p45058","p45059","p45060","p45061"},
    			};
    	public String[][] getOper_flag() {
    		return this.oper_flag;
    	}
        public String getP490() {
        	return this.P490;
        }
        public String getP491() {
        	return this.P491;
        }
        public String getP820() {
        	return this.P820;
        }
        public String getP492() {
        	return this.P492;
        }
        public String getP493() {
        	return this.P493;
        }
        public String getP494() {
        	return this.P494;
        }
        public String getP495() {
        	return this.P495;
        }
        public String getP496() {
        	return this.P496;
        }
        public String getP497() {
        	return this.P497;
        }
        public String getP498() {
        	return this.P498;
        }
        public String getP4981() {
        	return this.P4981;
        }
        public String getP499() {
        	return this.P499;
        }
        public String getP4910() {
        	return this.P4910;
        }
        public String getP4911() {
        	return this.P4911;
        }
        public String getP4912() {
        	return this.P4912;
        }
        public String getP821() {
        	return this.P821;
        }
        public String getP4913() {
        	return this.P4913;
        }
        public String getP4914() {
        	return this.P4914;
        }
        public String getP4915() {
        	return this.P4915;
        }
        public String getP4916() {
        	return this.P4916;
        }
        public String getP4917() {
        	return this.P4917;
        }
        public String getP4918() {
        	return this.P4918;
        }
        public String getP4919() {
        	return this.P4919;
        }
        public String getP4982() {
        	return this.P4982;
        }
        public String getP4920() {
        	return this.P4920;
        }
        public String getP4921() {
        	return this.P4921;
        }
        public String getP4922() {
        	return this.P4922;
        }
        public String getP4923() {
        	return this.P4923;
        }
        public String getP822() {
        	return this.P822;
        }
        public String getP4924() {
        	return this.P4924;
        }
        public String getP4925() {
        	return this.P4925;
        }
        public String getP4526() {
        	return this.P4526;
        }
        public String getP4527() {
        	return this.P4527;
        }
        public String getP4528() {
        	return this.P4528;
        }
        public String getP4529() {
        	return this.P4529;
        }
        public String getP4530() {
        	return this.P4530;
        }
        public String getP4983() {
        	return this.P4983;
        }
        public String getP4531() {
        	return this.P4531;
        }
        public String getP4532() {
        	return this.P4532;
        }
        public String getP4533() {
        	return this.P4533;
        }
        public String getP4534() {
        	return this.P4534;
        }
        public String getP823() {
        	return this.P823;
        }
        public String getP4535() {
        	return this.P4535;
        }
        public String getP4536() {
        	return this.P4536;
        }
        public String getP4537() {
        	return this.P4537;
        }
        public String getP4538() {
        	return this.P4538;
        }
        public String getP4539() {
        	return this.P4539;
        }
        public String getP4540() {
        	return this.P4540;
        }
        public String getP4541() {
        	return this.P4541;
        }
        public String getP4984() {
        	return this.P4984;
        }
        public String getP4542() {
        	return this.P4542;
        }
        public String getP4543() {
        	return this.P4543;
        }
        public String getP4544() {
        	return this.P4544;
        }
        public String getP4545() {
        	return this.P4545;
        }
        public String getP824() {
        	return this.P824;
        }
        public String getP4546() {
        	return this.P4546;
        }
        public String getP4547() {
        	return this.P4547;
        }
        public String getP4548() {
        	return this.P4548;
        }
        public String getP4549() {
        	return this.P4549;
        }
        public String getP4550() {
        	return this.P4550;
        }
        public String getP4551() {
        	return this.P4551;
        }
        public String getP4552() {
        	return this.P4552;
        }
        public String getP4985() {
        	return this.P4985;
        }
        public String getP4553() {
        	return this.P4553;
        }
        public String getP4554() {
        	return this.P4554;
        }
        public String getP45002() {
        	return this.P45002;
        }
        public String getP45003() {
        	return this.P45003;
        }
        public String getP825() {
        	return this.P825;
        }
        public String getp45004() {
        	return this.p45004;
        }
        public String getp45005() {
        	return this.p45005;
        }
        public String getp45006() {
        	return this.p45006;
        }
        public String getp45007() {
        	return this.p45007;
        }
        public String getp45008() {
        	return this.p45008;
        }
        public String getp45009() {
        	return this.p45009;
        }
        public String getp45010() {
        	return this.p45010;
        }
        public String getp45011() {
        	return this.p45011;
        }
        public String getp45012() {
        	return this.p45012;
        }
        public String getp45013() {
        	return this.p45013;
        }
        public String getp45014() {
        	return this.p45014;
        }
        public String getp45015() {
        	return this.p45015;
        }
        public String getP826() {
        	return this.P826;
        }
        public String getp45016() {
        	return this.p45016;
        }
        public String getp45017() {
        	return this.p45017;
        }
        public String getp45018() {
        	return this.p45018;
        }
        public String getp45019() {
        	return this.p45019;
        }
        public String getp45020() {
        	return this.p45020;
        }
        public String getp45021() {
        	return this.p45021;
        }
        public String getp45022() {
        	return this.p45022;
        }
        public String getp45023() {
        	return this.p45023;
        }
        public String getp45024() {
        	return this.p45024;
        }
        public String getp45025() {
        	return this.p45025;
        }
        public String getp45026() {
        	return this.p45026;
        }
        public String getp45027() {
        	return this.p45027;
        }
        public String getP827() {
        	return this.P827;
        }
        public String getp45028() {
        	return this.p45028;
        }
        public String getp45029() {
        	return this.p45029;
        }
        public String getp45030() {
        	return this.p45030;
        }
        public String getp45031() {
        	return this.p45031;
        }
        public String getp45032() {
        	return this.p45032;
        }
        public String getp45033() {
        	return this.p45033;
        }
        public String getp45034() {
        	return this.p45034;
        }
        public String getp45035() {
        	return this.p45035;
        }
        public String getp45036() {
        	return this.p45036;
        }
        public String getp45037() {
        	return this.p45037;
        }
        public String getp45038() {
        	return this.p45038;
        }
        public String getp45039() {
        	return this.p45039;
        }
        public String getP828() {
        	return this.P828;
        }
        public String getp45040() {
        	return this.p45040;
        }
        public String getp45041() {
        	return this.p45041;
        }
        public String getp45042() {
        	return this.p45042;
        }
        public String getp45043() {
        	return this.p45043;
        }
        public String getp45044() {
        	return this.p45044;
        }
        public String getp45045() {
        	return this.p45045;
        }
        public String getp45046() {
        	return this.p45046;
        }
        public String getp45047() {
        	return this.p45047;
        }
        public String getp45048() {
        	return this.p45048;
        }
        public String getp45049() {
        	return this.p45049;
        }
        public String getp45050() {
        	return this.p45050;
        }
        public String getp45051() {
        	return this.p45051;
        }
        public String getP829() {
        	return this.P829;
        }
        public String getp45052() {
        	return this.p45052;
        }
        public String getp45053() {
        	return this.p45053;
        }
        public String getp45054() {
        	return this.p45054;
        }
        public String getp45055() {
        	return this.p45055;
        }
        public String getp45056() {
        	return this.p45056;
        }
        public String getp45057() {
        	return this.p45057;
        }
        public String getp45058() {
        	return this.p45058;
        }
        public String getp45059() {
        	return this.p45059;
        }
        public String getp45060() {
        	return this.p45060;
        }
        public String getp45061() {
        	return this.p45061;
        }
        public void setP490(String P490) {
        	this.P490 = P490;
        }
        public void setP491(String P491) {
        	this.P491 = P491;
        }
        public void setP820(String P820) {
        	this.P820 = P820;
        }
        public void setP492(String P492) {
        	this.P492 = P492;
        }
        public void setP493(String P493) {
        	this.P493 = P493;
        }
        public void setP494(String P494) {
        	this.P494 = P494;
        }
        public void setP495(String P495) {
        	this.P495 = P495;
        }
        public void setP496(String P496) {
        	this.P496 = P496;
        }
        public void setP497(String P497) {
        	this.P497 = P497;
        }
        public void setP498(String P498) {
        	this.P498 = P498;
        }
        public void setP4981(String P4981) {
        	this.P4981 = P4981;
        }
        public void setP499(String P499) {
        	this.P499 = P499;
        }
        public void setP4910(String P4910) {
        	this.P4910 = P4910;
        }
        public void setP4911(String P4911) {
        	this.P4911 = P4911;
        }
        public void setP4912(String P4912) {
        	this.P4912 = P4912;
        }
        public void setP821(String P821) {
        	this.P821 = P821;
        }
        public void setP4913(String P4913) {
        	this.P4913 = P4913;
        }
        public void setP4914(String P4914) {
        	this.P4914 = P4914;
        }
        public void setP4915(String P4915) {
        	this.P4915 = P4915;
        }
        public void setP4916(String P4916) {
        	this.P4916 = P4916;
        }
        public void setP4917(String P4917) {
        	this.P4917 = P4917;
        }
        public void setP4918(String P4918) {
        	this.P4918 = P4918;
        }
        public void setP4919(String P4919) {
        	this.P4919 = P4919;
        }
        public void setP4982(String P4982) {
        	this.P4982 = P4982;
        }
        public void setP4920(String P4920) {
        	this.P4920 = P4920;
        }
        public void setP4921(String P4921) {
        	this.P4921 = P4921;
        }
        public void setP4922(String P4922) {
        	this.P4922 = P4922;
        }
        public void setP4923(String P4923) {
        	this.P4923 = P4923;
        }
        public void setP822(String P822) {
        	this.P822 = P822;
        }
        public void setP4924(String P4924) {
        	this.P4924 = P4924;
        }
        public void setP4925(String P4925) {
        	this.P4925 = P4925;
        }
        public void setP4526(String P4526) {
        	this.P4526 = P4526;
        }
        public void setP4527(String P4527) {
        	this.P4527 = P4527;
        }
        public void setP4528(String P4528) {
        	this.P4528 = P4528;
        }
        public void setP4529(String P4529) {
        	this.P4529 = P4529;
        }
        public void setP4530(String P4530) {
        	this.P4530 = P4530;
        }
        public void setP4983(String P4983) {
        	this.P4983 = P4983;
        }
        public void setP4531(String P4531) {
        	this.P4531 = P4531;
        }
        public void setP4532(String P4532) {
        	this.P4532 = P4532;
        }
        public void setP4533(String P4533) {
        	this.P4533 = P4533;
        }
        public void setP4534(String P4534) {
        	this.P4534 = P4534;
        }
        public void setP823(String P823) {
        	this.P823 = P823;
        }
        public void setP4535(String P4535) {
        	this.P4535 = P4535;
        }
        public void setP4536(String P4536) {
        	this.P4536 = P4536;
        }
        public void setP4537(String P4537) {
        	this.P4537 = P4537;
        }
        public void setP4538(String P4538) {
        	this.P4538 = P4538;
        }
        public void setP4539(String P4539) {
        	this.P4539 = P4539;
        }
        public void setP4540(String P4540) {
        	this.P4540 = P4540;
        }
        public void setP4541(String P4541) {
        	this.P4541 = P4541;
        }
        public void setP4984(String P4984) {
        	this.P4984 = P4984;
        }
        public void setP4542(String P4542) {
        	this.P4542 = P4542;
        }
        public void setP4543(String P4543) {
        	this.P4543 = P4543;
        }
        public void setP4544(String P4544) {
        	this.P4544 = P4544;
        }
        public void setP4545(String P4545) {
        	this.P4545 = P4545;
        }
        public void setP824(String P824) {
        	this.P824 = P824;
        }
        public void setP4546(String P4546) {
        	this.P4546 = P4546;
        }
        public void setP4547(String P4547) {
        	this.P4547 = P4547;
        }
        public void setP4548(String P4548) {
        	this.P4548 = P4548;
        }
        public void setP4549(String P4549) {
        	this.P4549 = P4549;
        }
        public void setP4550(String P4550) {
        	this.P4550 = P4550;
        }
        public void setP4551(String P4551) {
        	this.P4551 = P4551;
        }
        public void setP4552(String P4552) {
        	this.P4552 = P4552;
        }
        public void setP4985(String P4985) {
        	this.P4985 = P4985;
        }
        public void setP4553(String P4553) {
        	this.P4553 = P4553;
        }
        public void setP4554(String P4554) {
        	this.P4554 = P4554;
        }
        public void setP45002(String P45002) {
        	this.P45002 = P45002;
        }
        public void setP45003(String P45003) {
        	this.P45003 = P45003;
        }
        public void setP825(String P825) {
        	this.P825 = P825;
        }
        public void setp45004(String p45004) {
        	this.p45004 = p45004;
        }
        public void setp45005(String p45005) {
        	this.p45005 = p45005;
        }
        public void setp45006(String p45006) {
        	this.p45006 = p45006;
        }
        public void setp45007(String p45007) {
        	this.p45007 = p45007;
        }
        public void setp45008(String p45008) {
        	this.p45008 = p45008;
        }
        public void setp45009(String p45009) {
        	this.p45009 = p45009;
        }
        public void setp45010(String p45010) {
        	this.p45010 = p45010;
        }
        public void setp45011(String p45011) {
        	this.p45011 = p45011;
        }
        public void setp45012(String p45012) {
        	this.p45012 = p45012;
        }
        public void setp45013(String p45013) {
        	this.p45013 = p45013;
        }
        public void setp45014(String p45014) {
        	this.p45014 = p45014;
        }
        public void setp45015(String p45015) {
        	this.p45015 = p45015;
        }
        public void setP826(String P826) {
        	this.P826 = P826;
        }
        public void setp45016(String p45016) {
        	this.p45016 = p45016;
        }
        public void setp45017(String p45017) {
        	this.p45017 = p45017;
        }
        public void setp45018(String p45018) {
        	this.p45018 = p45018;
        }
        public void setp45019(String p45019) {
        	this.p45019 = p45019;
        }
        public void setp45020(String p45020) {
        	this.p45020 = p45020;
        }
        public void setp45021(String p45021) {
        	this.p45021 = p45021;
        }
        public void setp45022(String p45022) {
        	this.p45022 = p45022;
        }
        public void setp45023(String p45023) {
        	this.p45023 = p45023;
        }
        public void setp45024(String p45024) {
        	this.p45024 = p45024;
        }
        public void setp45025(String p45025) {
        	this.p45025 = p45025;
        }
        public void setp45026(String p45026) {
        	this.p45026 = p45026;
        }
        public void setp45027(String p45027) {
        	this.p45027 = p45027;
        }
        public void setP827(String P827) {
        	this.P827 = P827;
        }
        public void setp45028(String p45028) {
        	this.p45028 = p45028;
        }
        public void setp45029(String p45029) {
        	this.p45029 = p45029;
        }
        public void setp45030(String p45030) {
        	this.p45030 = p45030;
        }
        public void setp45031(String p45031) {
        	this.p45031 = p45031;
        }
        public void setp45032(String p45032) {
        	this.p45032 = p45032;
        }
        public void setp45033(String p45033) {
        	this.p45033 = p45033;
        }
        public void setp45034(String p45034) {
        	this.p45034 = p45034;
        }
        public void setp45035(String p45035) {
        	this.p45035 = p45035;
        }
        public void setp45036(String p45036) {
        	this.p45036 = p45036;
        }
        public void setp45037(String p45037) {
        	this.p45037 = p45037;
        }
        public void setp45038(String p45038) {
        	this.p45038 = p45038;
        }
        public void setp45039(String p45039) {
        	this.p45039 = p45039;
        }
        public void setP828(String P828) {
        	this.P828 = P828;
        }
        public void setp45040(String p45040) {
        	this.p45040 = p45040;
        }
        public void setp45041(String p45041) {
        	this.p45041 = p45041;
        }
        public void setp45042(String p45042) {
        	this.p45042 = p45042;
        }
        public void setp45043(String p45043) {
        	this.p45043 = p45043;
        }
        public void setp45044(String p45044) {
        	this.p45044 = p45044;
        }
        public void setp45045(String p45045) {
        	this.p45045 = p45045;
        }
        public void setp45046(String p45046) {
        	this.p45046 = p45046;
        }
        public void setp45047(String p45047) {
        	this.p45047 = p45047;
        }
        public void setp45048(String p45048) {
        	this.p45048 = p45048;
        }
        public void setp45049(String p45049) {
        	this.p45049 = p45049;
        }
        public void setp45050(String p45050) {
        	this.p45050 = p45050;
        }
        public void setp45051(String p45051) {
        	this.p45051 = p45051;
        }
        public void setP829(String P829) {
        	this.P829 = P829;
        }
        public void setp45052(String p45052) {
        	this.p45052 = p45052;
        }
        public void setp45053(String p45053) {
        	this.p45053 = p45053;
        }
        public void setp45054(String p45054) {
        	this.p45054 = p45054;
        }
        public void setp45055(String p45055) {
        	this.p45055 = p45055;
        }
        public void setp45056(String p45056) {
        	this.p45056 = p45056;
        }
        public void setp45057(String p45057) {
        	this.p45057 = p45057;
        }
        public void setp45058(String p45058) {
        	this.p45058 = p45058;
        }
        public void setp45059(String p45059) {
        	this.p45059 = p45059;
        }
        public void setp45060(String p45060) {
        	this.p45060 = p45060;
        }
        public void setp45061(String p45061) {
        	this.p45061 = p45061;
        }
    	public void reset_operation() {
    		P490 = null;
        	P491 = null;
        	P820 = null;
        	P492 = null;
        	P493 = null;
        	P494 = null;
        	P495 = null;
        	P496 = null;
        	P497 = null;
        	P498 = null;
        	P4981 = null;
        	P499 = null;
        	P4910 = null;
        	P4911 = null;
        	P4912 = null;
        	P821 = null;
        	P4913 = null;
        	P4914 = null;
        	P4915 = null;
        	P4916 = null;
        	P4917 = null;
        	P4918 = null;
        	P4919 = null;
        	P4982 = null;
        	P4920 = null;
        	P4921 = null;
        	P4922 = null;
        	P4923 = null;
        	P822 = null;
        	P4924 = null;
        	P4925 = null;
        	P4526 = null;
        	P4527 = null;
        	P4528 = null;
        	P4529 = null;
        	P4530 = null;
        	P4983 = null;
        	P4531 = null;
        	P4532 = null;
        	P4533 = null;
        	P4534 = null;
        	P823 = null;
        	P4535 = null;
        	P4536 = null;
        	P4537 = null;
        	P4538 = null;
        	P4539 = null;
        	P4540 = null;
        	P4541 = null;
        	P4984 = null;
        	P4542 = null;
        	P4543 = null;
        	P4544 = null;
        	P4545 = null;
        	P824 = null;
        	P4546 = null;
        	P4547 = null;
        	P4548 = null;
        	P4549 = null;
        	P4550 = null;
        	P4551 = null;
        	P4552 = null;
        	P4985 = null;
        	P4553 = null;
        	P4554 = null;
        	P45002 = null;
        	P45003 = null;
        	P825 = null;
        	p45004 = null;
        	p45005 = null;
        	p45006 = null;
        	p45007 = null;
        	p45008 = null;
        	p45009 = null;
        	p45010 = null;
        	p45011 = null;
        	p45012 = null;
        	p45013 = null;
        	p45014 = null;
        	p45015 = null;
        	P826 = null;
        	p45016 = null;
        	p45017 = null;
        	p45018 = null;
        	p45019 = null;
        	p45020 = null;
        	p45021 = null;
        	p45022 = null;
        	p45023 = null;
        	p45024 = null;
        	p45025 = null;
        	p45026 = null;
        	p45027 = null;
        	P827 = null;
        	p45028 = null;
        	p45029 = null;
        	p45030 = null;
        	p45031 = null;
        	p45032 = null;
        	p45033 = null;
        	p45034 = null;
        	p45035 = null;
        	p45036 = null;
        	p45037 = null;
        	p45038 = null;
        	p45039 = null;
        	P828 = null;
        	p45040 = null;
        	p45041 = null;
        	p45042 = null;
        	p45043 = null;
        	p45044 = null;
        	p45045 = null;
        	p45046 = null;
        	p45047 = null;
        	p45048 = null;
        	p45049 = null;
        	p45050 = null;
        	p45051 = null;
        	P829 = null;
        	p45052 = null;
        	p45053 = null;
        	p45054 = null;
        	p45055 = null;
        	p45056 = null;
        	p45057 = null;
        	p45058 = null;
        	p45059 = null;
        	p45060 = null;
        	p45061 = null;
    	}
    }
    static
    {
    	columnMap = new HashMap<String, String>();
    	columnMap.put("P900","医疗机构代码P900");
    	columnMap.put("P6891","机构名称P6891");
    	columnMap.put("P686","医疗保险手册（卡号）P686");
    	columnMap.put("P800","健康卡号P800");
    	columnMap.put("P1","医疗付款方式P1");
    	columnMap.put("P2","住院次数P2");
    	columnMap.put("P3","病案号P3");
    	columnMap.put("P4","姓名P4");
    	columnMap.put("P5","性别P5");
    	columnMap.put("P6","出生日期P6");
    	columnMap.put("P7","年龄P7");
    	columnMap.put("P8","婚姻状况P8");
    	columnMap.put("P9","职业P9");
    	columnMap.put("P101","出生省份P101");
    	columnMap.put("P102","出生地市P102");
    	columnMap.put("P103","出生地县P103");
    	columnMap.put("P11","民族P11");
    	columnMap.put("P12","国籍P12");
    	columnMap.put("P13","身份证号P13");
    	columnMap.put("P801","现住址P801");
    	columnMap.put("P802","住宅电话P802");
    	columnMap.put("P803","现住址邮政编码P803");
    	columnMap.put("P14","工作单位及地址P14");
    	columnMap.put("P15","电话P15");
    	columnMap.put("P16","工作单位邮政编码P16");
    	columnMap.put("P17","户口地址P17");
    	columnMap.put("P171","户口所在地邮政编码P171");
    	columnMap.put("P18","联系人姓名P18");
    	columnMap.put("P19","关系P19");
    	columnMap.put("P20","联系人地址P20");
    	columnMap.put("P804","入院途径P804");
    	columnMap.put("P21","联系人电话P21");
    	columnMap.put("P22","入院日期P22");
    	columnMap.put("P23","入院科别P23");
    	columnMap.put("P231","入院病室P231");
    	columnMap.put("P24","转科科别P24");
    	columnMap.put("P25","出院日期P25");
    	columnMap.put("P26","出院科别P26");
    	columnMap.put("P261","出院病室P261");
    	columnMap.put("P27","实际住院天数P27");
    	columnMap.put("P28","门（急）诊诊断编码P28");
    	columnMap.put("P281","门（急）诊诊断描述P281");
    	columnMap.put("P29","入院时情况P29");
    	columnMap.put("P30","入院诊断编码P30");
    	columnMap.put("P301","入院诊断描述P301");
    	columnMap.put("P31","入院后确诊日期P31");
    	columnMap.put("P689","医院感染总次数P689");
    	columnMap.put("P351","病理诊断编码1P351");
    	columnMap.put("P352","病理诊断名称1P352");
    	columnMap.put("P816","病理号1P816");
    	columnMap.put("P353","病理诊断编码2P353");
    	columnMap.put("P354","病理诊断名称2P354");
    	columnMap.put("P817","病理号2P817");
    	columnMap.put("P355","病理诊断编码3P355");
    	columnMap.put("P356","病理诊断名称3P356");
    	columnMap.put("P818","病理号3P818");
    	columnMap.put("P361","损伤、中毒的外部因素编码1P361");
    	columnMap.put("P362","损伤、中毒的外部因素名称1P362");
    	columnMap.put("P363","损伤、中毒的外部因素编码2P363");
    	columnMap.put("P364","损伤、中毒的外部因素名称2P364");
    	columnMap.put("P365","损伤、中毒的外部因素编码3P365");
    	columnMap.put("P366","损伤、中毒的外部因素名称3P366");
    	columnMap.put("P371","过敏源P371");
    	columnMap.put("P372","过敏药物名称P372");
    	columnMap.put("P38","HBsAgP38");
    	columnMap.put("P39","HCV-AbP39");
    	columnMap.put("P40","HIV-AbP40");
    	columnMap.put("P411","门诊与出院诊断符合情况P411");
    	columnMap.put("P412","入院与出院诊断符合情况P412");
    	columnMap.put("P413","术前与术后诊断符合情况P413");
    	columnMap.put("P414","临床与病理诊断符合情况P414");
    	columnMap.put("P415","放射与病理诊断符合情况P415");
    	columnMap.put("P421","抢救次数P421");
    	columnMap.put("P422","抢救成功次数P422");
    	columnMap.put("P687","最高诊断依据P687");
    	columnMap.put("P688","分化程度P688");
    	columnMap.put("P431","科主任P431");
    	columnMap.put("P432","主(副主)任医师P432");
    	columnMap.put("P433","主治医师P433");
    	columnMap.put("P434","住院医师P434");
    	columnMap.put("P819","责任护士P819");
    	columnMap.put("P435","进修医师P435");
    	columnMap.put("P436","研究生实习医师P436");
    	columnMap.put("P437","实习医师P437");
    	columnMap.put("P438","编码员P438");
    	columnMap.put("P44","病案质量P44");
    	columnMap.put("P45","质控医师P45");
    	columnMap.put("P46","质控护师P46");
    	columnMap.put("P47","质控日期P47");
    	columnMap.put("P490","手术操作编码1P490");
    	columnMap.put("P491","手术操作日期1P491");
    	columnMap.put("P820","手术级别1P820");
    	columnMap.put("P492","手术操作名称1P492");
    	columnMap.put("P493","手术操作部位1P493");
    	columnMap.put("P494","手术持续时间1P494");
    	columnMap.put("P495","术者1P495");
    	columnMap.put("P496","Ⅰ助1P496");
    	columnMap.put("P497","Ⅱ助1P497");
    	columnMap.put("P498","麻醉方式1P498");
    	columnMap.put("P4981","麻醉分级1P4981");
    	columnMap.put("P499","切口愈合等级1P499");
    	columnMap.put("P4910","麻醉医师1P4910");
    	columnMap.put("P4911","手术操作编码2P4911");
    	columnMap.put("P4912","手术操作日期2P4912");
    	columnMap.put("P821","手术级别2P821");
    	columnMap.put("P4913","手术操作名称2P4913");
    	columnMap.put("P4914","手术操作部位2P4914");
    	columnMap.put("P4915","手术持续时间2P4915");
    	columnMap.put("P4916","术者2P4916");
    	columnMap.put("P4917","Ⅰ助2P4917");
    	columnMap.put("P4918","Ⅱ助2P4918");
    	columnMap.put("P4919","麻醉方式2P4919");
    	columnMap.put("P4982","麻醉分级2P4982");
    	columnMap.put("P4920","切口愈合等级2P4920");
    	columnMap.put("P4921","麻醉医师2P4921");
    	columnMap.put("P4922","手术操作编码3P4922");
    	columnMap.put("P4923","手术操作日期3P4923");
    	columnMap.put("P822","手术级别3P822");
    	columnMap.put("P4924","手术操作名称3P4924");
    	columnMap.put("P4925","手术操作部位3P4925");
    	columnMap.put("P4526","手术持续时间3P4526");
    	columnMap.put("P4527","术者3P4527");
    	columnMap.put("P4528","Ⅰ助3P4528");
    	columnMap.put("P4529","Ⅱ助3P4529");
    	columnMap.put("P4530","麻醉方式3P4530");
    	columnMap.put("P4983","麻醉分级3P4983");
    	columnMap.put("P4531","切口愈合等级3P4531");
    	columnMap.put("P4532","麻醉医师3P4532");
    	columnMap.put("P4533","手术操作编码4P4533");
    	columnMap.put("P4534","手术操作日期4P4534");
    	columnMap.put("P823","手术级别4P823");
    	columnMap.put("P4535","手术操作名称4P4535");
    	columnMap.put("P4536","手术操作部位4P4536");
    	columnMap.put("P4537","手术持续时间4P4537");
    	columnMap.put("P4538","术者4P4538");
    	columnMap.put("P4539","Ⅰ助4P4539");
    	columnMap.put("P4540","Ⅱ助4P4540");
    	columnMap.put("P4541","麻醉方式4P4541");
    	columnMap.put("P4984","麻醉分级4P4984");
    	columnMap.put("P4542","切口愈合等级4P4542");
    	columnMap.put("P4543","麻醉医师4P4543");
    	columnMap.put("P4544","手术操作编码5P4544");
    	columnMap.put("P4545","手术操作日期5P4545");
    	columnMap.put("P824","手术级别5P824");
    	columnMap.put("P4546","手术操作名称5P4546");
    	columnMap.put("P4547","手术操作部位5P4547");
    	columnMap.put("P4548","手术持续时间5P4548");
    	columnMap.put("P4549","术者5P4549");
    	columnMap.put("P4550","Ⅰ助5P4550");
    	columnMap.put("P4551","Ⅱ助5P4551");
    	columnMap.put("P4552","麻醉方式5P4552");
    	columnMap.put("P4985","麻醉分级5P4985");
    	columnMap.put("P4553","切口愈合等级5P4553");
    	columnMap.put("P4554","麻醉医师5P4554");
    	columnMap.put("P45002","手术操作编码6P45002");
    	columnMap.put("P45003","手术操作日期6P45003");
    	columnMap.put("P825","手术级别6P825");
    	columnMap.put("p45004","手术操作名称6p45004");
    	columnMap.put("p45005","手术操作部位6p45005");
    	columnMap.put("p45006","手术持续时间6p45006");
    	columnMap.put("p45007","术者6p45007");
    	columnMap.put("p45008","Ⅰ助6p45008");
    	columnMap.put("p45009","Ⅱ助6p45009");
    	columnMap.put("p45010","麻醉方式6p45010");
    	columnMap.put("p45011","麻醉分级6p45011");
    	columnMap.put("p45012","切口愈合等级6p45012");
    	columnMap.put("p45013","麻醉医师6p45013");
    	columnMap.put("p45014","手术操作编码7p45014");
    	columnMap.put("p45015","手术操作日期7p45015");
    	columnMap.put("P826","手术级别7P826");
    	columnMap.put("p45016","手术操作名称7p45016");
    	columnMap.put("p45017","手术操作部位7p45017");
    	columnMap.put("p45018","手术持续时间7p45018");
    	columnMap.put("p45019","术者7p45019");
    	columnMap.put("p45020","Ⅰ助7p45020");
    	columnMap.put("p45021","Ⅱ助7p45021");
    	columnMap.put("p45022","麻醉方式7p45022");
    	columnMap.put("p45023","麻醉分级7p45023");
    	columnMap.put("p45024","切口愈合等级7p45024");
    	columnMap.put("p45025","麻醉医师7p45025");
    	columnMap.put("p45026","手术操作编码8p45026");
    	columnMap.put("p45027","手术操作日期8p45027");
    	columnMap.put("P827","手术级别8P827");
    	columnMap.put("p45028","手术操作名称8p45028");
    	columnMap.put("p45029","手术操作部位8p45029");
    	columnMap.put("p45030","手术持续时间8p45030");
    	columnMap.put("p45031","术者8p45031");
    	columnMap.put("p45032","Ⅰ助8p45032");
    	columnMap.put("p45033","Ⅱ助8p45033");
    	columnMap.put("p45034","麻醉方式8p45034");
    	columnMap.put("p45035","麻醉分级8p45035");
    	columnMap.put("p45036","切口愈合等级8p45036");
    	columnMap.put("p45037","麻醉医师8p45037");
    	columnMap.put("p45038","手术操作编码9p45038");
    	columnMap.put("p45039","手术操作日期9p45039");
    	columnMap.put("P828","手术级别9P828");
    	columnMap.put("p45040","手术操作名称9p45040");
    	columnMap.put("p45041","手术操作部位9p45041");
    	columnMap.put("p45042","手术持续时间9p45042");
    	columnMap.put("p45043","术者9p45043");
    	columnMap.put("p45044","Ⅰ助9p45044");
    	columnMap.put("p45045","Ⅱ助9p45045");
    	columnMap.put("p45046","麻醉方式9p45046");
    	columnMap.put("p45047","麻醉分级9p45047");
    	columnMap.put("p45048","切口愈合等级9p45048");
    	columnMap.put("p45049","麻醉医师9p45049");
    	columnMap.put("p45050","手术操作编码10p45050");
    	columnMap.put("p45051","手术操作日期10p45051");
    	columnMap.put("P829","手术级别10P829");
    	columnMap.put("p45052","手术操作名称10p45052");
    	columnMap.put("p45053","手术操作部位10p45053");
    	columnMap.put("p45054","手术持续时间10p45054");
    	columnMap.put("p45055","术者10p45055");
    	columnMap.put("p45056","Ⅰ助10p45056");
    	columnMap.put("p45057","Ⅱ助10p45057");
    	columnMap.put("p45058","麻醉方式10p45058");
    	columnMap.put("p45059","麻醉分级10p45059");
    	columnMap.put("p45060","切口愈合等级10p45060");
    	columnMap.put("p45061","麻醉医师10p45061");
    	columnMap.put("P561","特级护理天数P561");
    	columnMap.put("P562","一级护理天数P562");
    	columnMap.put("P563","二级护理天数P563");
    	columnMap.put("P564","三级护理天数P564");
    	columnMap.put("P6911","重症监护室名称1P6911");
    	columnMap.put("P6912","进入时间1P6912");
    	columnMap.put("P6913","退出时间1P6913");
    	columnMap.put("P6914","重症监护室名称2P6914");
    	columnMap.put("P6915","进入时间2P6915");
    	columnMap.put("P6916","退出时间2P6916");
    	columnMap.put("P6917","重症监护室名称3P6917");
    	columnMap.put("P6918","进入时间3P6918");
    	columnMap.put("P6919","退出时间3P6919");
    	columnMap.put("P6920","重症监护室名称4P6920");
    	columnMap.put("P6921","进入时间4P6921");
    	columnMap.put("P6922","退出时间4P6922");
    	columnMap.put("P6923","重症监护室名称5P6923");
    	columnMap.put("P6924","进入时间5P6924");
    	columnMap.put("P6925","退出时间5P6925");
    	columnMap.put("P57","死亡患者尸检P57");
    	columnMap.put("P58","手术、治疗、检查、诊断为本院第一例P58");
    	columnMap.put("P581","手术患者类型P581");
    	columnMap.put("P60","随诊P60");
    	columnMap.put("P611","随诊周数P611");
    	columnMap.put("P612","随诊月数P612");
    	columnMap.put("P613","随诊年数P613");
    	columnMap.put("P59","示教病例P59");
    	columnMap.put("P62","ABO血型P62");
    	columnMap.put("P63","Rh血型P63");
    	columnMap.put("P64","输血反应P64");
    	columnMap.put("P651","红细胞P651");
    	columnMap.put("P652","血小板P652");
    	columnMap.put("P653","血浆P653");
    	columnMap.put("P654","全血P654");
    	columnMap.put("P655","自体回收P655");
    	columnMap.put("P656","其它P656");
    	columnMap.put("P66","（年龄不足1 周岁的）年龄P66");
    	columnMap.put("P681","新生儿出生体重1P681");
    	columnMap.put("P682","新生儿出生体重2P682");
    	columnMap.put("P683","新生儿出生体重3P683");
    	columnMap.put("P684","新生儿出生体重4P684");
    	columnMap.put("P685","新生儿出生体重5P685");
    	columnMap.put("P67","新生儿入院体重P67");
    	columnMap.put("P731","入院前多少小时(颅脑损伤患者昏迷时间)P731");
    	columnMap.put("P732","入院前多少分钟(颅脑损伤患者昏迷时间)P732");
    	columnMap.put("P733","入院后多少小时(颅脑损伤患者昏迷时间)P733");
    	columnMap.put("P734","入院后多少分钟(颅脑损伤患者昏迷时间)P734");
    	columnMap.put("P72","呼吸机使用时间P72");
    	columnMap.put("P830","是否有出院31天内再住院计划P830");
    	columnMap.put("P831","出院31天再住院计划目的P831");
    	columnMap.put("P741","离院方式P741");
    	columnMap.put("P742","转入医院名称P742");
    	columnMap.put("P743","转入社区服务机构/乡镇卫生院名称P743");
    	columnMap.put("P782","住院总费用P782");
    	columnMap.put("P751","住院总费用其中自付金额P751");
    	columnMap.put("P752","一般医疗服务费P752");
    	columnMap.put("P754","一般治疗操作费P754");
    	columnMap.put("P755","护理费P755");
    	columnMap.put("P756","综合医疗服务类其他费用P756");
    	columnMap.put("P757","病理诊断费P757");
    	columnMap.put("P758","实验室诊断费P758");
    	columnMap.put("P759","影像学诊断费P759");
    	columnMap.put("P760","临床诊断项目费P760");
    	columnMap.put("P761","非手术治疗项目费P761");
    	columnMap.put("P762","临床物理治疗费P762");
    	columnMap.put("P763","手术治疗费P763");
    	columnMap.put("P764","麻醉费P764");
    	columnMap.put("P765","手术费P765");
    	columnMap.put("P767","康复费P767");
    	columnMap.put("P768","中医治疗费P768");
    	columnMap.put("P769","西药费P769");
    	columnMap.put("P770","抗菌药物费用P770");
    	columnMap.put("P771","中成药费P771");
    	columnMap.put("P772","中草药费P772");
    	columnMap.put("P773","血费P773");
    	columnMap.put("P774","白蛋白类制品费P774");
    	columnMap.put("P775","球蛋白类制品费P775");
    	columnMap.put("P776","凝血因子类制品费P776");
    	columnMap.put("P777","细胞因子类制品费P777");
    	columnMap.put("P778","检查用一次性医用材料费P778");
    	columnMap.put("P779","治疗用一次性医用材料费P779");
    	columnMap.put("P780","手术用一次性医用材料费P780");
    	columnMap.put("P781","其他费P781");
    	
    	lenth_map = new HashMap<String, Integer>();
    	lenth_map.put("P900",22);
      lenth_map.put("P6891",80);
      lenth_map.put("P686",50);
      lenth_map.put("p800",50);
      lenth_map.put("P1",1);
      lenth_map.put("P3",20);
      lenth_map.put("P4",40);
      lenth_map.put("P5",1);
      lenth_map.put("P8",1);
      lenth_map.put("P9",2);
      lenth_map.put("P101",30);
      lenth_map.put("P102",30);
      lenth_map.put("P103",30);
      lenth_map.put("P11",20);
      lenth_map.put("P12",40);
      lenth_map.put("P13",18);
      lenth_map.put("P801",200);
      lenth_map.put("P802",40);
      lenth_map.put("P803",6);
      lenth_map.put("P14",200);
      lenth_map.put("P15",40);
      lenth_map.put("P16",6);
      lenth_map.put("P17",200);
      lenth_map.put("P171",6);
      lenth_map.put("P18",20);
      lenth_map.put("P19",40);
      lenth_map.put("P20",200);
      lenth_map.put("P804",1);
      lenth_map.put("P21",30);
      lenth_map.put("P23",6);
      lenth_map.put("P231",30);
      lenth_map.put("P24",6);
      lenth_map.put("P26",6);
      lenth_map.put("P261",30);
      lenth_map.put("P28",20);
      lenth_map.put("P281",100);
      lenth_map.put("P29",1);
      lenth_map.put("P30",30);
      lenth_map.put("P301",100);
      lenth_map.put("P321",20);
      lenth_map.put("P322",100);
      lenth_map.put("P805",1);
      lenth_map.put("P323",1);
      lenth_map.put("P324",20);
      lenth_map.put("P325",100);
      lenth_map.put("P806",1);
      lenth_map.put("P326",1);
      lenth_map.put("P327",20);
      lenth_map.put("P328",100);
      lenth_map.put("P807",1);
      lenth_map.put("P329",1);
      lenth_map.put("P3291",20);
      lenth_map.put("P3292",100);
      lenth_map.put("P808",1);
      lenth_map.put("P3293",1);
      lenth_map.put("P3294",20);
      lenth_map.put("P3295",100);
      lenth_map.put("P809",1);
      lenth_map.put("P3296",1);
      lenth_map.put("P3297",20);
      lenth_map.put("P3298",100);
      lenth_map.put("P810",1);
      lenth_map.put("P3299",1);
      lenth_map.put("P3281",20);
      lenth_map.put("P3282",100);
      lenth_map.put("P811",1);
      lenth_map.put("P3283",1);
      lenth_map.put("P3284",20);
      lenth_map.put("P3285",100);
      lenth_map.put("P812",1);
      lenth_map.put("P3286",1);
      lenth_map.put("P3287",20);
      lenth_map.put("P3288",100);
      lenth_map.put("P813",1);
      lenth_map.put("P3289",1);
      lenth_map.put("P3271",20);
      lenth_map.put("P3272",100);
      lenth_map.put("P814",1);
      lenth_map.put("P3273",1);
      lenth_map.put("P3274",20);
      lenth_map.put("P3275",100);
      lenth_map.put("P815",1);
      lenth_map.put("P3276",1);
      lenth_map.put("P351",20);
      lenth_map.put("P352",100);
      lenth_map.put("P816",50);
      lenth_map.put("P353",20);
      lenth_map.put("P354",100);
      lenth_map.put("P817",50);
      lenth_map.put("P355",20);
      lenth_map.put("P356",100);
      lenth_map.put("P818",50);
      lenth_map.put("P361",20);
      lenth_map.put("P362",100);
      lenth_map.put("P363",20);
      lenth_map.put("P364",100);
      lenth_map.put("P365",20);
      lenth_map.put("P366",100);
      lenth_map.put("P371",35);
      lenth_map.put("P372",100);
      lenth_map.put("P38",1);
      lenth_map.put("P39",1);
      lenth_map.put("P40",1);
      lenth_map.put("P411",1);
      lenth_map.put("P412",1);
      lenth_map.put("P413",1);
      lenth_map.put("P414",1);
      lenth_map.put("P415",1);
      lenth_map.put("P687",1);
      lenth_map.put("P688",1);
      lenth_map.put("P431",40);
      lenth_map.put("P432",40);
      lenth_map.put("P433",40);
      lenth_map.put("P434",40);
      lenth_map.put("P819",40);
      lenth_map.put("P435",40);
      lenth_map.put("P436",40);
      lenth_map.put("P437",40);
      lenth_map.put("P438",40);
      lenth_map.put("P44",1);
      lenth_map.put("P45",40);
      lenth_map.put("P46",40);
      lenth_map.put("P490",20);
      lenth_map.put("P820",1);
      lenth_map.put("P492",100);
      lenth_map.put("P493",4);
      lenth_map.put("P495",40);
      lenth_map.put("P496",40);
      lenth_map.put("P497",40);
      lenth_map.put("P498",6);
      lenth_map.put("P4981",1);
      lenth_map.put("P499",2);
      lenth_map.put("P4910",40);
      lenth_map.put("P4911",20);
      lenth_map.put("P821",1);
      lenth_map.put("P4913",100);
      lenth_map.put("P4914",4);
      lenth_map.put("P4916",40);
      lenth_map.put("P4917",40);
      lenth_map.put("P4918",40);
      lenth_map.put("P4919",6);
      lenth_map.put("P4982",1);
      lenth_map.put("P4920",2);
      lenth_map.put("P4921",40);
      lenth_map.put("P4922",40);
      lenth_map.put("P822",1);
      lenth_map.put("P4924",100);
      lenth_map.put("P4925",4);
      lenth_map.put("P4527",40);
      lenth_map.put("P4528",40);
      lenth_map.put("P4529",40);
      lenth_map.put("P4530",6);
      lenth_map.put("P4983",1);
      lenth_map.put("P4531",2);
      lenth_map.put("P4532",40);
      lenth_map.put("P4533",20);
      lenth_map.put("P823",1);
      lenth_map.put("P4535",100);
      lenth_map.put("P4536",4);
      lenth_map.put("P4538",40);
      lenth_map.put("P4539",40);
      lenth_map.put("P4540",40);
      lenth_map.put("P4541",6);
      lenth_map.put("P4984",1);
      lenth_map.put("P4542",2);
      lenth_map.put("P4543",40);
      lenth_map.put("P4544",20);
      lenth_map.put("P824",1);
      lenth_map.put("P4546",100);
      lenth_map.put("P4547",100);
      lenth_map.put("P4549",40);
      lenth_map.put("P4550",40);
      lenth_map.put("P4551",40);
      lenth_map.put("P4552",6);
      lenth_map.put("P4985",1);
      lenth_map.put("P4553",2);
      lenth_map.put("P4554",40);
      lenth_map.put("P45002",20);
      lenth_map.put("P825",1);
      lenth_map.put("P45004",100);
      lenth_map.put("P45005",4);
      lenth_map.put("P45007",40);
      lenth_map.put("P45008",40);
      lenth_map.put("P45009",40);
      lenth_map.put("P45010",6);
      lenth_map.put("P45011",1);
      lenth_map.put("P45012",2);
      lenth_map.put("P45013",40);
      lenth_map.put("P45014",20);
      lenth_map.put("P826",1);
      lenth_map.put("P45016",100);
      lenth_map.put("P45017",4);
      lenth_map.put("P45019",40);
      lenth_map.put("P45020",40);
      lenth_map.put("P45021",40);
      lenth_map.put("P45022",6);
      lenth_map.put("P45023",1);
      lenth_map.put("P45024",2);
      lenth_map.put("P45025",40);
      lenth_map.put("P45026",20);
      lenth_map.put("P827",1);
      lenth_map.put("P45028",100);
      lenth_map.put("P45029",4);
      lenth_map.put("P45031",40);
      lenth_map.put("P45032",40);
      lenth_map.put("P45033",40);
      lenth_map.put("P45034",6);
      lenth_map.put("P45035",1);
      lenth_map.put("P45036",2);
      lenth_map.put("P45037",40);
      lenth_map.put("P45038",20);
      lenth_map.put("P828",1);
      lenth_map.put("P45040",100);
      lenth_map.put("P45041",4);
      lenth_map.put("P45043",40);
      lenth_map.put("P45044",40);
      lenth_map.put("P45045",40);
      lenth_map.put("P45046",6);
      lenth_map.put("P45047",1);
      lenth_map.put("P45048",2);
      lenth_map.put("P45049",40);
      lenth_map.put("P45050",20);
      lenth_map.put("P829",1);
      lenth_map.put("P45052",100);
      lenth_map.put("P45053",4);
      lenth_map.put("P45055",40);
      lenth_map.put("P45056",40);
      lenth_map.put("P45057",40);
      lenth_map.put("P45058",6);
      lenth_map.put("P45059",1);
      lenth_map.put("P45060",2);
      lenth_map.put("P45061",40);
      lenth_map.put("P6911",4);
      lenth_map.put("P6914",4);
      lenth_map.put("P6917",4);
      lenth_map.put("P6920",4);
      lenth_map.put("P6923",4);
      lenth_map.put("P57",1);
      lenth_map.put("P58",1);
      lenth_map.put("P581",1);
      lenth_map.put("P60",1);
      lenth_map.put("P59",1);
      lenth_map.put("P62",1);
      lenth_map.put("P63",1);
      lenth_map.put("P64",1);
      lenth_map.put("P830",1);
      lenth_map.put("P831",100);
      lenth_map.put("P741",1);
      lenth_map.put("P742",100);
      lenth_map.put("P743",100);	
    }
    
    public Patient() {
    	
    }
    
    public void KillPatient() {
    	P900 = null;
    	P6891 = null;
    	P686 = null;
    	P800 = null;
    	P1 = null;
    	P2 = null;
    	P3 = null;
    	P4 = null;
    	P5 = null;
    	P6 = null;
    	P7 = null;
    	P8 = null;
    	P9 = null;
    	P101 = null;
    	P102 = null;
    	P103 = null;
    	P11 = null;
    	P12 = null;
    	P13 = null;
    	P801 = null;
    	P802 = null;
    	P803 = null;
    	P14 = null;
    	P15 = null;
    	P16 = null;
    	P17 = null;
    	P171 = null;
    	P18 = null;
    	P19 = null;
    	P20 = null;
    	P804 = null;
    	P21 = null;
    	P22 = null;
    	P23 = null;
    	P231 = null;
    	P24 = null;
    	P25 = null;
    	P26 = null;
    	P261 = null;
    	P27 = null;
    	P28 = null;
    	P281 = null;
    	P29 = null;
    	P30 = null;
    	P301 = null;
    	P31 = null;
    	P689 = null;
    	P351 = null;
    	P352 = null;
    	P816 = null;
    	P353 = null;
    	P354 = null;
    	P817 = null;
    	P355 = null;
    	P356 = null;
    	P818 = null;
    	P361 = null;
    	P362 = null;
    	P363 = null;
    	P364 = null;
    	P365 = null;
    	P366 = null;
    	P371 = null;
    	P372 = null;
    	P38 = null;
    	P39 = null;
    	P40 = null;
    	P411 = null;
    	P412 = null;
    	P413 = null;
    	P414 = null;
    	P415 = null;
    	P421 = null;
    	P422 = null;
    	P687 = null;
    	P688 = null;
    	P431 = null;
    	P432 = null;
    	P433 = null;
    	P434 = null;
    	P819 = null;
    	P435 = null;
    	P436 = null;
    	P437 = null;
    	P438 = null;
    	P44 = null;
    	P45 = null;
    	P46 = null;
    	P47 = null;
    	P561 = null;
    	P562 = null;
    	P563 = null;
    	P564 = null;
    	P6911 = null;
    	P6912 = null;
    	P6913 = null;
    	P6914 = null;
    	P6915 = null;
    	P6916 = null;
    	P6917 = null;
    	P6918 = null;
    	P6919 = null;
    	P6920 = null;
    	P6921 = null;
    	P6922 = null;
    	P6923 = null;
    	P6924 = null;
    	P6925 = null;
    	P57 = null;
    	P58 = null;
    	P581 = null;
    	P60 = null;
    	P611 = null;
    	P612 = null;
    	P613 = null;
    	P59 = null;
    	P62 = null;
    	P63 = null;
    	P64 = null;
    	P651 = null;
    	P652 = null;
    	P653 = null;
    	P654 = null;
    	P655 = null;
    	P656 = null;
    	P66 = null;
    	P681 = null;
    	P682 = null;
    	P683 = null;
    	P684 = null;
    	P685 = null;
    	P67 = null;
    	P731 = null;
    	P732 = null;
    	P733 = null;
    	P734 = null;
    	P72 = null;
    	P830 = null;
    	P831 = null;
    	P741 = null;
    	P742 = null;
    	P743 = null;
    	P782 = null;
    	P751 = null;
    	P752 = null;
    	P754 = null;
    	P755 = null;
    	P756 = null;
    	P757 = null;
    	P758 = null;
    	P759 = null;
    	P760 = null;
    	P761 = null;
    	P762 = null;
    	P763 = null;
    	P764 = null;
    	P765 = null;
    	P767 = null;
    	P768 = null;
    	P769 = null;
    	P770 = null;
    	P771 = null;
    	P772 = null;
    	P773 = null;
    	P774 = null;
    	P775 = null;
    	P776 = null;
    	P777 = null;
    	P778 = null;
    	P779 = null;
    	P780 = null;
    	P781 = null;

    }

    // Patient Setter/Getter Below

    public String getP900() {
    	return this.P900;
    }
    public String getP6891() {
    	return this.P6891;
    }
    public String getP686() {
    	return this.P686;
    }
    public String getP800() {
    	return this.P800;
    }
    public String getP1() {
    	return this.P1;
    }
    public String getP2() {
    	return this.P2;
    }
    public String getP3() {
    	return this.P3;
    }
    public String getP4() {
    	return this.P4;
    }
    public String getP5() {
    	return this.P5;
    }
    public String getP6() {
    	return this.P6;
    }
    public String getP7() {
    	return this.P7;
    }
    public String getP8() {
    	return this.P8;
    }
    public String getP9() {
    	return this.P9;
    }
    public String getP101() {
    	return this.P101;
    }
    public String getP102() {
    	return this.P102;
    }
    public String getP103() {
    	return this.P103;
    }
    public String getP11() {
    	return this.P11;
    }
    public String getP12() {
    	return this.P12;
    }
    public String getP13() {
    	return this.P13;
    }
    public String getP801() {
    	return this.P801;
    }
    public String getP802() {
    	return this.P802;
    }
    public String getP803() {
    	return this.P803;
    }
    public String getP14() {
    	return this.P14;
    }
    public String getP15() {
    	return this.P15;
    }
    public String getP16() {
    	return this.P16;
    }
    public String getP17() {
    	return this.P17;
    }
    public String getP171() {
    	return this.P171;
    }
    public String getP18() {
    	return this.P18;
    }
    public String getP19() {
    	return this.P19;
    }
    public String getP20() {
    	return this.P20;
    }
    public String getP804() {
    	return this.P804;
    }
    public String getP21() {
    	return this.P21;
    }
    public String getP22() {
    	return this.P22;
    }
    public String getP23() {
    	return this.P23;
    }
    public String getP231() {
    	return this.P231;
    }
    public String getP24() {
    	return this.P24;
    }
    public String getP25() {
    	return this.P25;
    }
    public String getP26() {
    	return this.P26;
    }
    public String getP261() {
    	return this.P261;
    }
    public String getP27() {
    	return this.P27;
    }
    public String getP28() {
    	return this.P28;
    }
    public String getP281() {
    	return this.P281;
    }
    public String getP29() {
    	return this.P29;
    }
    public String getP30() {
    	return this.P30;
    }
    public String getP301() {
    	return this.P301;
    }
    public String getP31() {
    	return this.P31;
    }
   
    public String getP689() {
    	return this.P689;
    }
    public String getP351() {
    	return this.P351;
    }
    public String getP352() {
    	return this.P352;
    }
    public String getP816() {
    	return this.P816;
    }
    public String getP353() {
    	return this.P353;
    }
    public String getP354() {
    	return this.P354;
    }
    public String getP817() {
    	return this.P817;
    }
    public String getP355() {
    	return this.P355;
    }
    public String getP356() {
    	return this.P356;
    }
    public String getP818() {
    	return this.P818;
    }
    public String getP361() {
    	return this.P361;
    }
    public String getP362() {
    	return this.P362;
    }
    public String getP363() {
    	return this.P363;
    }
    public String getP364() {
    	return this.P364;
    }
    public String getP365() {
    	return this.P365;
    }
    public String getP366() {
    	return this.P366;
    }
    public String getP371() {
    	return this.P371;
    }
    public String getP372() {
    	return this.P372;
    }
    public String getP38() {
    	return this.P38;
    }
    public String getP39() {
    	return this.P39;
    }
    public String getP40() {
    	return this.P40;
    }
    public String getP411() {
    	return this.P411;
    }
    public String getP412() {
    	return this.P412;
    }
    public String getP413() {
    	return this.P413;
    }
    public String getP414() {
    	return this.P414;
    }
    public String getP415() {
    	return this.P415;
    }
    public String getP421() {
    	return this.P421;
    }
    public String getP422() {
    	return this.P422;
    }
    public String getP687() {
    	return this.P687;
    }
    public String getP688() {
    	return this.P688;
    }
    public String getP431() {
    	return this.P431;
    }
    public String getP432() {
    	return this.P432;
    }
    public String getP433() {
    	return this.P433;
    }
    public String getP434() {
    	return this.P434;
    }
    public String getP819() {
    	return this.P819;
    }
    public String getP435() {
    	return this.P435;
    }
    public String getP436() {
    	return this.P436;
    }
    public String getP437() {
    	return this.P437;
    }
    public String getP438() {
    	return this.P438;
    }
    public String getP44() {
    	return this.P44;
    }
    public String getP45() {
    	return this.P45;
    }
    public String getP46() {
    	return this.P46;
    }
    public String getP47() {
    	return this.P47;
    }

    public String getP561() {
    	return this.P561;
    }
    public String getP562() {
    	return this.P562;
    }
    public String getP563() {
    	return this.P563;
    }
    public String getP564() {
    	return this.P564;
    }
    public String getP6911() {
    	return this.P6911;
    }
    public String getP6912() {
    	return this.P6912;
    }
    public String getP6913() {
    	return this.P6913;
    }
    public String getP6914() {
    	return this.P6914;
    }
    public String getP6915() {
    	return this.P6915;
    }
    public String getP6916() {
    	return this.P6916;
    }
    public String getP6917() {
    	return this.P6917;
    }
    public String getP6918() {
    	return this.P6918;
    }
    public String getP6919() {
    	return this.P6919;
    }
    public String getP6920() {
    	return this.P6920;
    }
    public String getP6921() {
    	return this.P6921;
    }
    public String getP6922() {
    	return this.P6922;
    }
    public String getP6923() {
    	return this.P6923;
    }
    public String getP6924() {
    	return this.P6924;
    }
    public String getP6925() {
    	return this.P6925;
    }
    public String getP57() {
    	return this.P57;
    }
    public String getP58() {
    	return this.P58;
    }
    public String getP581() {
    	return this.P581;
    }
    public String getP60() {
    	return this.P60;
    }
    public String getP611() {
    	return this.P611;
    }
    public String getP612() {
    	return this.P612;
    }
    public String getP613() {
    	return this.P613;
    }
    public String getP59() {
    	return this.P59;
    }
    public String getP62() {
    	return this.P62;
    }
    public String getP63() {
    	return this.P63;
    }
    public String getP64() {
    	return this.P64;
    }
    public String getP651() {
    	return this.P651;
    }
    public String getP652() {
    	return this.P652;
    }
    public String getP653() {
    	return this.P653;
    }
    public String getP654() {
    	return this.P654;
    }
    public String getP655() {
    	return this.P655;
    }
    public String getP656() {
    	return this.P656;
    }
    public String getP66() {
    	return this.P66;
    }
    public String getP681() {
    	return this.P681;
    }
    public String getP682() {
    	return this.P682;
    }
    public String getP683() {
    	return this.P683;
    }
    public String getP684() {
    	return this.P684;
    }
    public String getP685() {
    	return this.P685;
    }
    public String getP67() {
    	return this.P67;
    }
    public String getP731() {
    	return this.P731;
    }
    public String getP732() {
    	return this.P732;
    }
    public String getP733() {
    	return this.P733;
    }
    public String getP734() {
    	return this.P734;
    }
    public String getP72() {
    	return this.P72;
    }
    public String getP830() {
    	return this.P830;
    }
    public String getP831() {
    	return this.P831;
    }
    public String getP741() {
    	return this.P741;
    }
    public String getP742() {
    	return this.P742;
    }
    public String getP743() {
    	return this.P743;
    }
    public String getP782() {
    	return this.P782;
    }
    public String getP751() {
    	return this.P751;
    }
    public String getP752() {
    	return this.P752;
    }
    public String getP754() {
    	return this.P754;
    }
    public String getP755() {
    	return this.P755;
    }
    public String getP756() {
    	return this.P756;
    }
    public String getP757() {
    	return this.P757;
    }
    public String getP758() {
    	return this.P758;
    }
    public String getP759() {
    	return this.P759;
    }
    public String getP760() {
    	return this.P760;
    }
    public String getP761() {
    	return this.P761;
    }
    public String getP762() {
    	return this.P762;
    }
    public String getP763() {
    	return this.P763;
    }
    public String getP764() {
    	return this.P764;
    }
    public String getP765() {
    	return this.P765;
    }
    public String getP767() {
    	return this.P767;
    }
    public String getP768() {
    	return this.P768;
    }
    public String getP769() {
    	return this.P769;
    }
    public String getP770() {
    	return this.P770;
    }
    public String getP771() {
    	return this.P771;
    }
    public String getP772() {
    	return this.P772;
    }
    public String getP773() {
    	return this.P773;
    }
    public String getP774() {
    	return this.P774;
    }
    public String getP775() {
    	return this.P775;
    }
    public String getP776() {
    	return this.P776;
    }
    public String getP777() {
    	return this.P777;
    }
    public String getP778() {
    	return this.P778;
    }
    public String getP779() {
    	return this.P779;
    }
    public String getP780() {
    	return this.P780;
    }
    public String getP781() {
    	return this.P781;
    }
    public void setP900(String P900) {
    	this.P900 = P900;
    }
    public void setP6891(String P6891) {
    	this.P6891 = P6891;
    }
    public void setP686(String P686) {
    	this.P686 = P686;
    }
    public void setP800(String P800) {
    	this.P800 = P800;
    }
    public void setP1(String P1) {
    	this.P1 = P1;
    }
    public void setP2(String P2) {
    	this.P2 = P2;
    }
    public void setP3(String P3) {
    	this.P3 = P3;
    }
    public void setP4(String P4) {
    	this.P4 = P4;
    }
    public void setP5(String P5) {
    	this.P5 = P5;
    }
    public void setP6(String P6) {
    	this.P6 = P6;
    }
    public void setP7(String P7) {
    	this.P7 = P7;
    }
    public void setP8(String P8) {
    	this.P8 = P8;
    }
    public void setP9(String P9) {
    	this.P9 = P9;
    }
    public void setP101(String P101) {
    	this.P101 = P101;
    }
    public void setP102(String P102) {
    	this.P102 = P102;
    }
    public void setP103(String P103) {
    	this.P103 = P103;
    }
    public void setP11(String P11) {
    	this.P11 = P11;
    }
    public void setP12(String P12) {
    	this.P12 = P12;
    }
    public void setP13(String P13) {
    	this.P13 = P13;
    }
    public void setP801(String P801) {
    	this.P801 = P801;
    }
    public void setP802(String P802) {
    	this.P802 = P802;
    }
    public void setP803(String P803) {
    	this.P803 = P803;
    }
    public void setP14(String P14) {
    	this.P14 = P14;
    }
    public void setP15(String P15) {
    	this.P15 = P15;
    }
    public void setP16(String P16) {
    	this.P16 = P16;
    }
    public void setP17(String P17) {
    	this.P17 = P17;
    }
    public void setP171(String P171) {
    	this.P171 = P171;
    }
    public void setP18(String P18) {
    	this.P18 = P18;
    }
    public void setP19(String P19) {
    	this.P19 = P19;
    }
    public void setP20(String P20) {
    	this.P20 = P20;
    }
    public void setP804(String P804) {
    	this.P804 = P804;
    }
    public void setP21(String P21) {
    	this.P21 = P21;
    }
    public void setP22(String P22) {
    	this.P22 = P22;
    }
    public void setP23(String P23) {
    	this.P23 = P23;
    }
    public void setP231(String P231) {
    	this.P231 = P231;
    }
    public void setP24(String P24) {
    	this.P24 = P24;
    }
    public void setP25(String P25) {
    	this.P25 = P25;
    }
    public void setP26(String P26) {
    	this.P26 = P26;
    }
    public void setP261(String P261) {
    	this.P261 = P261;
    }
    public void setP27(String P27) {
    	this.P27 = P27;
    }
    public void setP28(String P28) {
    	this.P28 = P28;
    }
    public void setP281(String P281) {
    	this.P281 = P281;
    }
    public void setP29(String P29) {
    	this.P29 = P29;
    }
    public void setP30(String P30) {
    	this.P30 = P30;
    }
    public void setP301(String P301) {
    	this.P301 = P301;
    }
    public void setP31(String P31) {
    	this.P31 = P31;
    }
    
    public void setP689(String P689) {
    	this.P689 = P689;
    }
    public void setP351(String P351) {
    	this.P351 = P351;
    }
    public void setP352(String P352) {
    	this.P352 = P352;
    }
    public void setP816(String P816) {
    	this.P816 = P816;
    }
    public void setP353(String P353) {
    	this.P353 = P353;
    }
    public void setP354(String P354) {
    	this.P354 = P354;
    }
    public void setP817(String P817) {
    	this.P817 = P817;
    }
    public void setP355(String P355) {
    	this.P355 = P355;
    }
    public void setP356(String P356) {
    	this.P356 = P356;
    }
    public void setP818(String P818) {
    	this.P818 = P818;
    }
    public void setP361(String P361) {
    	this.P361 = P361;
    }
    public void setP362(String P362) {
    	this.P362 = P362;
    }
    public void setP363(String P363) {
    	this.P363 = P363;
    }
    public void setP364(String P364) {
    	this.P364 = P364;
    }
    public void setP365(String P365) {
    	this.P365 = P365;
    }
    public void setP366(String P366) {
    	this.P366 = P366;
    }
    public void setP371(String P371) {
    	this.P371 = P371;
    }
    public void setP372(String P372) {
    	this.P372 = P372;
    }
    public void setP38(String P38) {
    	this.P38 = P38;
    }
    public void setP39(String P39) {
    	this.P39 = P39;
    }
    public void setP40(String P40) {
    	this.P40 = P40;
    }
    public void setP411(String P411) {
    	this.P411 = P411;
    }
    public void setP412(String P412) {
    	this.P412 = P412;
    }
    public void setP413(String P413) {
    	this.P413 = P413;
    }
    public void setP414(String P414) {
    	this.P414 = P414;
    }
    public void setP415(String P415) {
    	this.P415 = P415;
    }
    public void setP421(String P421) {
    	this.P421 = P421;
    }
    public void setP422(String P422) {
    	this.P422 = P422;
    }
    public void setP687(String P687) {
    	this.P687 = P687;
    }
    public void setP688(String P688) {
    	this.P688 = P688;
    }
    public void setP431(String P431) {
    	this.P431 = P431;
    }
    public void setP432(String P432) {
    	this.P432 = P432;
    }
    public void setP433(String P433) {
    	this.P433 = P433;
    }
    public void setP434(String P434) {
    	this.P434 = P434;
    }
    public void setP819(String P819) {
    	this.P819 = P819;
    }
    public void setP435(String P435) {
    	this.P435 = P435;
    }
    public void setP436(String P436) {
    	this.P436 = P436;
    }
    public void setP437(String P437) {
    	this.P437 = P437;
    }
    public void setP438(String P438) {
    	this.P438 = P438;
    }
    public void setP44(String P44) {
    	this.P44 = P44;
    }
    public void setP45(String P45) {
    	this.P45 = P45;
    }
    public void setP46(String P46) {
    	this.P46 = P46;
    }
    public void setP47(String P47) {
    	this.P47 = P47;
    }

    public void setP561(String P561) {
    	this.P561 = P561;
    }
    public void setP562(String P562) {
    	this.P562 = P562;
    }
    public void setP563(String P563) {
    	this.P563 = P563;
    }
    public void setP564(String P564) {
    	this.P564 = P564;
    }
    public void setP6911(String P6911) {
    	this.P6911 = P6911;
    }
    public void setP6912(String P6912) {
    	this.P6912 = P6912;
    }
    public void setP6913(String P6913) {
    	this.P6913 = P6913;
    }
    public void setP6914(String P6914) {
    	this.P6914 = P6914;
    }
    public void setP6915(String P6915) {
    	this.P6915 = P6915;
    }
    public void setP6916(String P6916) {
    	this.P6916 = P6916;
    }
    public void setP6917(String P6917) {
    	this.P6917 = P6917;
    }
    public void setP6918(String P6918) {
    	this.P6918 = P6918;
    }
    public void setP6919(String P6919) {
    	this.P6919 = P6919;
    }
    public void setP6920(String P6920) {
    	this.P6920 = P6920;
    }
    public void setP6921(String P6921) {
    	this.P6921 = P6921;
    }
    public void setP6922(String P6922) {
    	this.P6922 = P6922;
    }
    public void setP6923(String P6923) {
    	this.P6923 = P6923;
    }
    public void setP6924(String P6924) {
    	this.P6924 = P6924;
    }
    public void setP6925(String P6925) {
    	this.P6925 = P6925;
    }
    public void setP57(String P57) {
    	this.P57 = P57;
    }
    public void setP58(String P58) {
    	this.P58 = P58;
    }
    public void setP581(String P581) {
    	this.P581 = P581;
    }
    public void setP60(String P60) {
    	this.P60 = P60;
    }
    public void setP611(String P611) {
    	this.P611 = P611;
    }
    public void setP612(String P612) {
    	this.P612 = P612;
    }
    public void setP613(String P613) {
    	this.P613 = P613;
    }
    public void setP59(String P59) {
    	this.P59 = P59;
    }
    public void setP62(String P62) {
    	this.P62 = P62;
    }
    public void setP63(String P63) {
    	this.P63 = P63;
    }
    public void setP64(String P64) {
    	this.P64 = P64;
    }
    public void setP651(String P651) {
    	this.P651 = P651;
    }
    public void setP652(String P652) {
    	this.P652 = P652;
    }
    public void setP653(String P653) {
    	this.P653 = P653;
    }
    public void setP654(String P654) {
    	this.P654 = P654;
    }
    public void setP655(String P655) {
    	this.P655 = P655;
    }
    public void setP656(String P656) {
    	this.P656 = P656;
    }
    public void setP66(String P66) {
    	this.P66 = P66;
    }
    public void setP681(String P681) {
    	this.P681 = P681;
    }
    public void setP682(String P682) {
    	this.P682 = P682;
    }
    public void setP683(String P683) {
    	this.P683 = P683;
    }
    public void setP684(String P684) {
    	this.P684 = P684;
    }
    public void setP685(String P685) {
    	this.P685 = P685;
    }
    public void setP67(String P67) {
    	this.P67 = P67;
    }
    public void setP731(String P731) {
    	this.P731 = P731;
    }
    public void setP732(String P732) {
    	this.P732 = P732;
    }
    public void setP733(String P733) {
    	this.P733 = P733;
    }
    public void setP734(String P734) {
    	this.P734 = P734;
    }
    public void setP72(String P72) {
    	this.P72 = P72;
    }
    public void setP830(String P830) {
    	this.P830 = P830;
    }
    public void setP831(String P831) {
    	this.P831 = P831;
    }
    public void setP741(String P741) {
    	this.P741 = P741;
    }
    public void setP742(String P742) {
    	this.P742 = P742;
    }
    public void setP743(String P743) {
    	this.P743 = P743;
    }
    public void setP782(String P782) {
    	this.P782 = P782;
    }
    public void setP751(String P751) {
    	this.P751 = P751;
    }
    public void setP752(String P752) {
    	this.P752 = P752;
    }
    public void setP754(String P754) {
    	this.P754 = P754;
    }
    public void setP755(String P755) {
    	this.P755 = P755;
    }
    public void setP756(String P756) {
    	this.P756 = P756;
    }
    public void setP757(String P757) {
    	this.P757 = P757;
    }
    public void setP758(String P758) {
    	this.P758 = P758;
    }
    public void setP759(String P759) {
    	this.P759 = P759;
    }
    public void setP760(String P760) {
    	this.P760 = P760;
    }
    public void setP761(String P761) {
    	this.P761 = P761;
    }
    public void setP762(String P762) {
    	this.P762 = P762;
    }
    public void setP763(String P763) {
    	this.P763 = P763;
    }
    public void setP764(String P764) {
    	this.P764 = P764;
    }
    public void setP765(String P765) {
    	this.P765 = P765;
    }
    public void setP767(String P767) {
    	this.P767 = P767;
    }
    public void setP768(String P768) {
    	this.P768 = P768;
    }
    public void setP769(String P769) {
    	this.P769 = P769;
    }
    public void setP770(String P770) {
    	this.P770 = P770;
    }
    public void setP771(String P771) {
    	this.P771 = P771;
    }
    public void setP772(String P772) {
    	this.P772 = P772;
    }
    public void setP773(String P773) {
    	this.P773 = P773;
    }
    public void setP774(String P774) {
    	this.P774 = P774;
    }
    public void setP775(String P775) {
    	this.P775 = P775;
    }
    public void setP776(String P776) {
    	this.P776 = P776;
    }
    public void setP777(String P777) {
    	this.P777 = P777;
    }
    public void setP778(String P778) {
    	this.P778 = P778;
    }
    public void setP779(String P779) {
    	this.P779 = P779;
    }
    public void setP780(String P780) {
    	this.P780 = P780;
    }
    public void setP781(String P781) {
    	this.P781 = P781;
    }


	public Map<String, String> getColumnMap() {
    	return columnMap;
    }
	
	public Map<String, Integer> getLenthMap() {
		return lenth_map;
	}
}
