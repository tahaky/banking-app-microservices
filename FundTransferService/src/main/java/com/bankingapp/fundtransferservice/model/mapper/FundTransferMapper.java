package com.bankingapp.fundtransferservice.model.mapper;


import com.bankingapp.fundtransferservice.model.FundTransfer;
import com.bankingapp.fundtransferservice.model.dto.FundTransferDto;
import org.springframework.beans.BeanUtils;

public class FundTransferMapper extends Mapper<FundTransfer, FundTransferDto> {

    @Override
    public FundTransfer mapToEntity(FundTransferDto fundTransferDto) {
        FundTransfer fundTransfer = new FundTransfer();
        BeanUtils.copyProperties(fundTransferDto, fundTransfer);
        return fundTransfer;
    }

    @Override
    public FundTransferDto mapToDto(FundTransfer transfer) {
        FundTransferDto fundTransferDto = new FundTransferDto();
        BeanUtils.copyProperties(transfer, fundTransferDto);
        return fundTransferDto;
    }
}
