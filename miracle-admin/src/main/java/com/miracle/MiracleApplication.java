package com.miracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author miracle
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MiracleApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(MiracleApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Ciallo～(∠・ω< )⌒★   ლ(´ڡ`ლ)ﾞ  \n" +
                "  .oooooo.    o8o            oooo  oooo             .oo.  .oo \n" +
                " d8P'  `Y8b   `\"'            `888  `888            P'  `YP'   \n" +
                "888          oooo   .oooo.    888   888   .ooooo.             \n" +
                "888          `888  `P  )88b   888   888  d88' `88b            \n" +
                "888           888   .oP\"888   888   888  888   888            \n" +
                "`88b    ooo   888  d8(  888   888   888  888   888            \n" +
                " `Y8bood8P'  o888o `Y888\"\"8o o888o o888o `Y8bod8P'            \n" +
                "                                                              \n" +
                "                                                              \n" +
                "                                                              ");
    }
}
