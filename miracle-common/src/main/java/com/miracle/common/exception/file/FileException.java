package com.miracle.common.exception.file;

import com.miracle.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author miracle
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
