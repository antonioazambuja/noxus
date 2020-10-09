package com.antonioazambuja.noxus;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.antonioazambuja.noxus.resources.Incident;
import com.antonioazambuja.noxus.resources.Message;
import com.antonioazambuja.noxus.resources.Service;
import com.antonioazambuja.noxus.resources.ShardStatus;
import com.antonioazambuja.noxus.resources.Translation;
import com.antonioazambuja.noxus.service.LolStatusV3Service;

@RunWith(MockitoJUnitRunner.class)
public class LolStatusV3Test {

	@Mock
    private LolStatusV3Service lolStatusV3;

	@Test
	public void getStatusShardDataTest() {
		List<String> locales = Arrays.asList("pt_BR");
		String hostname = "prod.br.lol.riotgames.com";
		String slug = "br";
		String name = "Brazil";
		String region_tag = "br1";
		String content = "Em 23/01/20, com início às 03:30 do horário de Brasília (05:30 UTC), as filas ranqueadas serão desativadas em preparação para a atualização 10.02. Às 05:00 do horário de Brasília (07:00 UTC), os servidores serão desligados, todas as partidas em andamento serão encerradas em empate e as estatísticas não serão gravadas. Estimamos que os Campos da Justiça fiquem indisponíveis por 3 horas.";
		String severity = "info";
		String created_at = "2020-01-22T02:27:04.188Z";
		String updated_at = "2020-01-22T02:27:04.188Z";
		String serviceName = "Game";
		String serviceSlug = "game";
		String status = "online";
		String messageId = "messageId";
		String authorId = "authorId";
		String heading = "10.02";
		Boolean incidentActive = true;
		Long incidentId = new Long(1);
		List<Translation> translations = Arrays.asList(new Translation(updated_at, "pt_BR", content));
		List<Message> messages = Arrays.asList(new Message(messageId, authorId, heading, content, severity, created_at, updated_at, translations));
		List<Incident> incidents = Arrays.asList(new Incident(incidentId, incidentActive, created_at, messages));
		List<Service> services = Arrays.asList(new Service(serviceName, serviceSlug, status, incidents));
		ShardStatus shardStatus = new ShardStatus(locales, hostname, name, services, slug, region_tag);
		Mockito
	        .when(lolStatusV3.getStatusShardData())
	        .thenReturn(shardStatus);
		Assert.assertEquals(lolStatusV3.getStatusShardData(), shardStatus);
		Mockito.verify(lolStatusV3).getStatusShardData();
	}
}
