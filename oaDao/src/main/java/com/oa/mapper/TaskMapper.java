package com.oa.mapper;

import com.oa.pojo.DateParam;
import com.oa.pojo.Holiday;

public interface TaskMapper {
	Holiday selectHoliday(DateParam dp);
}
