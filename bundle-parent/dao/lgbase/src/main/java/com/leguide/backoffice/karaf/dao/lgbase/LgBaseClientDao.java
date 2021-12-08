package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.client.LgBaseClient;

public interface LgBaseClientDao {

	LgBaseClient findClient(String clientId);

	LgBaseClient findClientByShopsiteId(String shopsiteId);

	void create(LgBaseClient client);

	void update(LgBaseClient client);

	void defineAsSageSource(String clientId);

	void updateReglementMode(String clientId, String type);
}
