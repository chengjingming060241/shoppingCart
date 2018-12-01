package com.cheer.util;

import com.cheer.dao.iocationMapper;
import com.cheer.model.Iocation;

public class IocationMapperImpl extends AbstractMapper implements iocationMapper {
    @Override
    public void getIocation(Integer userId) {
        super.Before();
        this.iocationMapper.getIocation(userId);
        super.After();
    }

    @Override
    public void getAnyIocation(Integer iocationId) {
        super.Before();
        this.iocationMapper.getAnyIocation(iocationId);
        super.After();
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
