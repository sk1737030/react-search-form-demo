package org.dongguri.reactsearchformdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dongguri.reactsearchformdemo.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SearchFormMapper {

    public List<UserVO> getGmamaListForIndex() throws Exception;
}
