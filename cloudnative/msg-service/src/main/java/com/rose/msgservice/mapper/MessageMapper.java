package com.rose.msgservice.mapper;

import com.rose.msgservice.dto.MessageDTO;
import com.rose.msgservice.model.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDTO messageToMessageDto(Message message);

    Message messageDtoToMessage(MessageDTO messageDTO);
}
