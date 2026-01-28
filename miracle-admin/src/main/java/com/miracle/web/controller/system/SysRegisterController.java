package com.miracle.web.controller.system;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.miracle.common.core.controller.BaseController;
import com.miracle.common.core.domain.AjaxResult;
import com.miracle.common.core.domain.model.RegisterBody;
import com.miracle.common.utils.StringUtils;
import com.miracle.framework.web.service.SysRegisterService;
import com.miracle.system.service.ISysConfigService;

/**
 * 注册验证
 * 
 * @author miracle
 */
@Tag(name = "注册验证")
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
