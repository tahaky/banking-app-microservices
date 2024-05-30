package com.bankibgapp.bankingservice.mapper;

import com.bankibgapp.bankingservice.dto.UtilityAccountDTO;
import com.bankibgapp.bankingservice.model.UtilityAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UtilityAccountMapper extends BaseMapper<UtilityAccount, UtilityAccountDTO> {
    @Override
    public UtilityAccount convertToEntity(UtilityAccountDTO dto, Object... args) {
        UtilityAccount utilityAccount = new UtilityAccount();
        if (dto != null) {
            BeanUtils.copyProperties(dto, utilityAccount);
        }
        return null;
    }

    @Override
    public UtilityAccountDTO convertToDto(UtilityAccount entity, Object... args) {
        UtilityAccountDTO utilityAccountDTO = new UtilityAccountDTO();
        if (entity != null) {
            BeanUtils.copyProperties(entity, utilityAccountDTO);
        }
        return utilityAccountDTO;
    }
}
