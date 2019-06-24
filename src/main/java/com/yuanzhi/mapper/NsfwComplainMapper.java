package com.yuanzhi.mapper;

import org.apache.ibatis.annotations.Param;

public interface NsfwComplainMapper {

	int selectCountByMonth(@Param("year")Integer year,@Param("month") int i);

}
