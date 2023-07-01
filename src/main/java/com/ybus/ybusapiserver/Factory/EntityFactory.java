package com.ybus.ybusapiserver.Factory;

import com.ybus.ybusapiserver.DTO.*;
import com.ybus.ybusapiserver.DTO.board.CommentDTO;
import com.ybus.ybusapiserver.DTO.board.PostDTO;
import com.ybus.ybusapiserver.JPA.Entity.board.Comment;
import com.ybus.ybusapiserver.JPA.Entity.board.Post;
import com.ybus.ybusapiserver.JPA.Entity.bus.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

@Component
public class EntityFactory {
    public BusLine busLinetoEntity(BusLineDTO busLineDTO){
        BusType busType = new BusType();
        busType.setBusTypeSeq(busLineDTO.getBusTypeSeq());
        BusLine busLine = BusLine.builder()
                .busLine(busLineDTO.getBusLine())
                .busLineState(busLineDTO.getBusLineState())
                .busTypeSeq(busType)
                .build();
        return busLine;
    }

    public BusStop busStopToEntity(BusStopDTO busStopDTO){
        BusLine busLine = new BusLine();
        busLine.setBusLineSeq(busStopDTO.getBusLineSeq());
        BusStop busStop = BusStop.builder()
                .busStop(busStopDTO.getBusStop())
                .busStopLine(busStopDTO.getBusStopLine())
                .isStopped(busStopDTO.getIsStopped())
                .busStopOrder(busStopDTO.getBusStopOrder())
                .latitude(busStopDTO.getLatitude())
                .longitude(busStopDTO.getLongitude())
                .busLineSeq(busLine)
                .build();
        return busStop;
    }

    public DeviceInfo deviceInfoToEntity(DeviceInfoDTO deviceInfoDTO){
        BusLine busLine = new BusLine();
        busLine.setBusLineSeq(deviceInfoDTO.getBusLine());

        BusType busType = new BusType();
        busType.setBusTypeSeq(deviceInfoDTO.getBusType());

        DeviceInfo deviceInfo = DeviceInfo.builder()
                .deviceRegdate(deviceInfoDTO.getDeviceRegdate())
                .deviceState(deviceInfoDTO.getDeviceState())
                .busNumber(deviceInfoDTO.getBusNumber())
                .busAlias(deviceInfoDTO.getBusAlias())
                .busType(busType)
                .busLine(busLine)
                .build();
        return deviceInfo;
    }

    public Device deviceToEntity(DeviceDTO deviceDTO){
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDeviceInfoSeq(deviceDTO.getDeviceSeq());

        Device device = Device.builder()
                .deviceHashKey(deviceDTO.getDeviceHashKey())
                .deviceName(deviceDTO.getDeviceName())
                .updateTime(deviceDTO.getUpdateTime())
                .deviceInfoSeq(deviceInfo)
                .build();
        return device;
    }

    public Location locationToEntity(LocationInsertDTO locationInsertDTO){

        ZoneId seoulZone = ZoneId.of("Asia/Seoul");
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(locationInsertDTO.getLocation_date()), seoulZone);

        Device device = new Device();
        device.setDeviceSeq(locationInsertDTO.getDeviceSeq());

        BusStop busStop = new BusStop();
        busStop.setBusStopSeq(locationInsertDTO.getBusStopSeq());


        Location location = Location.builder()
                .locationTime(dateTime)
                .latitude(Double.toString(locationInsertDTO.getLatitude()))
                .longitude(Double.toString(locationInsertDTO.getLongitude()))
                .busStopSeq(busStop)
                .deviceSeq(device)
                .isWithinRange(locationInsertDTO.getIsWithinRange())
                .build();

        return  location;
    }

    public BusSchedule busScheduleToEntity(BusScheduleDTO busScheduleDTO){
        BusLine busLine = new BusLine();
        busLine.setBusLineSeq(busScheduleDTO.getBusLineSeq());

        LocalTime busTime = LocalTime.of(busScheduleDTO.getTimeHour(), busScheduleDTO.getTimeMinute());

        BusSchedule busSchedule = BusSchedule.builder()
                .busTime(busTime)
                .courseName(busScheduleDTO.getCourseName())
                .weekDays(busScheduleDTO.getWeekDays())
                .busLineSeq(busLine)
                .busUpdataTime(LocalDateTime.now())
                .build();

        return busSchedule;
    }

    public Comment commentToEntity(CommentDTO commentDTO){
        Post post = new Post();
        post.setPostSeq(commentDTO.getPostSeq());

        Comment comment = Comment.builder()
                .content(commentDTO.getContent())
                .writer(commentDTO.getWriterName())
                .state("show")
                .writedTime(LocalDateTime.now())
                .postSeq(post)
                .build();
        return comment;
    }

    public Post postToEntity(PostDTO postDTO){
        Post post = Post.builder()
                .subject(postDTO.getSubject())
                .content(postDTO.getContent())
                .writer(postDTO.getWriterName())
                .writedTime(LocalDateTime.now())
                .tag(postDTO.getTag())
                .state("show")
                .build();
        return post;
    }
}
