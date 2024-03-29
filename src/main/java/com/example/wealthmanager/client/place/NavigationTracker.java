package com.example.wealthmanager.client.place;

import com.arcbees.analytics.shared.Analytics;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationHandler;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public class NavigationTracker implements NavigationHandler {
    private final Analytics analytics;
    private final PlaceManager placeManager;

    @Inject
    NavigationTracker(final PlaceManager placeManager, final EventBus eventBus, final Analytics analytics) {
        this.analytics = analytics;
        this.placeManager = placeManager;
        eventBus.addHandler(NavigationEvent.getType(), this);
    }

    @Override
    public void onNavigation(final NavigationEvent navigationEvent) {
        analytics.sendPageView().documentPath(placeManager.buildHistoryToken(navigationEvent.getRequest())).go();
    }
}