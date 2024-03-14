package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
public class Main {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        Client client = new Client();
        client.setName("John");
        clientCrudService.create(client);

        Planet planet = new Planet();
        planet.setId("SAT");
        planet.setName("Saturn");
        planetCrudService.create(planet);

        Client readClient = clientCrudService.read(Client.class, client.getId());
        Planet readPlanet = planetCrudService.read(Planet.class, planet.getId());

        readClient.setName("Jane Doe");
        clientCrudService.update(readClient);

        readPlanet.setName("Mars (updated)");
        planetCrudService.update(readPlanet);

        clientCrudService.delete(readClient);
        planetCrudService.delete(readPlanet);

        HibernateUtil.getInstance().close();
    }
}