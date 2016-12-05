package com.wjdiankong.parseresource.type;

public class ResTableConfig {
	
	//uiMode
	public final static int MASK_UI_MODE_TYPE = 0;
	public final static int UI_MODE_TYPE_ANY = 0x00;
	public final static int UI_MODE_TYPE_NORMAL =  0x01;
	public final static int UI_MODE_TYPE_DESK = 0x02;
	public final static int UI_MODE_TYPE_CAR = 0x03;
	public final static int UI_MODE_TYPE_TELEVISION = 0x04;
	public final static int UI_MODE_TYPE_APPLIANCE = 0x05;
	public final static int UI_MODE_TYPE_WATCH = 0x06;
	public final static int MASK_UI_MODE_NIGHT = 0;
	public final static int SHIFT_UI_MODE_NIGHT = 0;
	public final static int UI_MODE_NIGHT_ANY = 0x00;
	public final static int UI_MODE_NIGHT_NO = 0x01;
	public final static int UI_MODE_NIGHT_YES = 0x02;
	
	//screenLayout
	public final static int MASK_SCREENSIZE = 0;
	public final static int SCREENSIZE_ANY = 0x00;
	public final static int SCREENSIZE_SMALL = 0x01;
	public final static int SCREENSIZE_NORMAL = 0x02;
	public final static int SCREENSIZE_LARGE = 0x03;
	public final static int SCREENSIZE_XLARGE = 0x04;
	public final static int MASK_SCREENLONG = 0;
	public final static int SHIFT_SCREENLONG = 0;
	public final static int SCREENLONG_ANY = 0x00;
	public final static int SCREENLONG_NO = 0x01;
	public final static int SCREENLONG_YES = 0x02;
	public final static int MASK_LAYOUTDIR = 0;
	public final static int SHIFT_LAYOUTDIR = 0;
	public final static int LAYOUTDIR_ANY = 0x00;
	public final static int LAYOUTDIR_LTR =  0x01;
	public final static int LAYOUTDIR_RTL = 0x02;
	
	/**
	 * uint32_t size;
	 */
	public int size;
	
	//运营商信息
    /*
    union {
        struct {
            // Mobile country code (from SIM).  0 means "any".
            uint16_t mcc;
            // Mobile network code (from SIM).  0 means "any".
            uint16_t mnc;
        };
        uint32_t imsi;
    };*/
    
    //这里使用的是union
    public short mcc;
    public short mnc;
    
    public int imsi;
    
    //本地化
    /*union {
        struct {
            char language[2];
            char country[2];
        };
        uint32_t locale;
    };*/
    //这里还是使用的union
    public byte[] language = new byte[2];
    public byte[] country = new byte[2];
    
    public int locale;
    
    //屏幕属性
    //这里还是采用union结构
    /**
     * union {
        struct {
            uint8_t orientation;
            uint8_t touchscreen;
            uint16_t density;
        };
        uint32_t screenType;
    };
     */
    public byte orientation;
    public byte touchscreen;
    public short density;
    
    public int screenType;
    
    //输入属性
    /**
     * union {
        struct {
            uint8_t keyboard;
            uint8_t navigation;
            uint8_t inputFlags;
            uint8_t inputPad0;
        };
        uint32_t input;
    };
     */
    //这里还是采用union结构体
    public byte keyboard;
    public byte navigation;
    public byte inputFlags;
    public byte inputPad0;
    
    public int input;
    
    //屏幕尺寸
    /**
     * union {
        struct {
            uint16_t screenWidth;
            uint16_t screenHeight;
        };
        uint32_t screenSize;
    };
     */
    //这里还是采用union结构体
    public short screenWidth;
    public short screenHeight;
    
    public int screenSize;
    
    //系统版本
    /**
     * union {
        struct {
            uint16_t sdkVersion;
            // For now minorVersion must always be 0!!!  Its meaning
            // is currently undefined.
            uint16_t minorVersion;
        };
        uint32_t version;
    };
     */
    //这里还是采用union结构体
    public short sdVersion;
    public short minorVersion;
    
    public int version;
    
    //屏幕配置
    /**
     * union {
        struct {
            uint8_t screenLayout;
            uint8_t uiMode;
            uint16_t smallestScreenWidthDp;
        };
        uint32_t screenConfig;
    };
    */
    //这里还是采用union结构体
    public byte screenLayout;
    public byte uiMode;
    public short smallestScreenWidthDp;
    
    public int screenConfig;
    
    //屏幕尺寸
    /**
     * union {
        struct {
            uint16_t screenWidthDp;
            uint16_t screenHeightDp;
        };
        uint32_t screenSizeDp;
    };
     */
    //这里还是采用union结构体
    public short screenWidthDp;
    public short screenHeightDp;
    
    public int screenSizeDp;
    
    /**
     *  char localeScript[4];
    	char localeVariant[8];
     */
    public byte[] localeScript = new byte[4];
    public byte[] localeVariant = new byte[8];
    
    public int getSize(){
    	return 48;
    }
    
    @Override
    public String toString(){
    	return "size:"+size+",mcc=" + mcc+",locale:"+locale+",screenType:"+screenType+",input:"+
    			input+",screenSize:"+screenSize+",version:"+version+",sdkVersion:"+sdVersion+",minVersion:"+minorVersion
    			+",screenConfig:"+screenConfig+ ",screenLayout:"+screenLayout + ",uiMode:"+uiMode + 
    			",smallestScreenWidthDp:"+smallestScreenWidthDp + ",screenSizeDp:"+screenSizeDp;
    }
    

}
