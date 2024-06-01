package com.bankibgapp.bankingservice.model.mapper;

import com.bankibgapp.bankingservice.model.dto.UtilityAccountDto;
import com.bankibgapp.bankingservice.model.entity.UtilityAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UtilityAccountMapper extends BaseMapper<UtilityAccount, UtilityAccountDto> {
    @Override
    public UtilityAccount convertToEntity(UtilityAccountDto dto, Object... args) {
        UtilityAccount utilityAccount = new UtilityAccount();
        if (dto != null) {
            BeanUtils.copyProperties(dto, utilityAccount);
        }
        return null;
    }

    @Override
    public UtilityAccountDto convertToDto(UtilityAccount entity, Object... args) {
        UtilityAccountDto utilityAccountDTO = new UtilityAccountDto();
        if (entity != null) {
            BeanUtils.copyProperties(entity, utilityAccountDTO);
        }
        return utilityAccountDTO;
    }
}
