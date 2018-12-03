package com.cheer.util;

import com.cheer.dao.iocationMapper;
import com.cheer.model.Iocation;

import java.util.List;

public class IocationMapperImpl extends AbstractMapper implements iocationMapper {
    @Override
    public List<Iocation> getIocation(String iocationUserName) {
        super.Before();
        List<Iocation> iocationList = this.iocationMapper.getIocation(iocationUserName);
        super.After();
        return iocationList;
    }

    @Override
    public Iocation getAnyIocation(Integer iocationId , String userName) {
        super.Before();
        Iocation iocation = this.iocationMapper.getAnyIocation(iocationId,userName);
        super.After();
        return iocation;
    }

    @Override
    public void updateIocation(Iocation iocation) {
        super.Before();
        this.iocationMapper.updateIocation(iocation);
        super.After();
    }

    @Override
    public void addIocation(Iocation iocation) {
        super.Before();
        this.iocationMapper.addIocation(iocation);
        super.After();
    }

    @Override
    public void deleteIocation(Integer iocationId) {
        super.Before();
        this.iocationMapper.deleteIocation(iocationId);
        super.After();
    }
}
