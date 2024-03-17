package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {

        /*Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:/Users/user/IdeaProjects/Hibernate/test.mv.db", "sa", null)
                .load();

        flyway.migrate();*/

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

        Client client = new Client();
        client.setName("John");
        clientCrudService.create(client);

        Planet planet = new Planet();
        planet.setId("SAT");
        planet.setName("Saturn");
        planetCrudService.create(planet);

        Planet secondPlanet = new Planet();
        secondPlanet.setId("NEP");
        secondPlanet.setName("Neptune");
        planetCrudService.create(secondPlanet);

        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setFromPlanet(planet);
        ticket.setToPlanet(secondPlanet);
        ticketCrudService.create(ticket);

        Client readClient = clientCrudService.read(Client.class, client.getId());
        Planet readPlanet = planetCrudService.read(Planet.class, planet.getId());
        Planet readSecondPlanet = planetCrudService.read(Planet.class, planet.getId());
        Ticket readTicket = ticketCrudService.read(Ticket.class, ticket.getId());

        ticketCrudService.delete(readTicket);

        readClient.setName("Jane");
        clientCrudService.update(readClient);

        readPlanet.setName("Nebula");
        planetCrudService.update(readPlanet);

        clientCrudService.delete(readClient);
        planetCrudService.delete(readPlanet);
        planetCrudService.delete(readSecondPlanet);

        HibernateUtil.getInstance().close();
    }
}