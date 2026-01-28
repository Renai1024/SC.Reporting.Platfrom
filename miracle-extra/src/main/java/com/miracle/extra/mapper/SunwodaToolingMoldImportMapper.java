package com.miracle.extra.mapper;

import com.miracle.common.annotation.DataSource;
import com.miracle.common.enums.DataSourceType;
import com.miracle.extra.domain.SunwodaToolingMoldImport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@DataSource(DataSourceType.SLAVE3)
@Mapper
public interface SunwodaToolingMoldImportMapper {
    public List<SunwodaToolingMoldImport> selectSunwodaToolingMoldImportList(SunwodaToolingMoldImport sunwodaToolingMoldImport);

    public List<SunwodaToolingMoldImport> selectSunwodaToolingMoldImportListByDate(@Param("date") Date date);
}
