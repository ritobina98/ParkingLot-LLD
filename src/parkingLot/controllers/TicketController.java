package parkingLot.controllers;

import parkingLot.dtos.*;
import parkingLot.models.Ticket;
import parkingLot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto){
        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();
        try{
            Ticket ticket =  ticketService.issueTicket(
                    requestDto.getVehicleNumber(),
                    requestDto.getOwnerName(),
                    requestDto.getGateId(),
                    requestDto.getOperatorId()
            );
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    public DeleteTicketResponseDto deleteTicket(DeleteTicketRequestDto deleteTicketRequestDto){
        return null;
    }
}
