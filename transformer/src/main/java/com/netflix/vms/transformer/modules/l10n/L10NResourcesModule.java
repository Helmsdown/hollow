package com.netflix.vms.transformer.modules.l10n;

import com.netflix.hollow.write.objectmapper.HollowObjectMapper;
import com.netflix.vms.transformer.common.TransformerContext;
import com.netflix.vms.transformer.hollowinput.MapKeyHollow;
import com.netflix.vms.transformer.hollowinput.MapOfTranslatedTextHollow;
import com.netflix.vms.transformer.hollowinput.StoriesSynopsesHollow;
import com.netflix.vms.transformer.hollowinput.StoriesSynopsesHookHollow;
import com.netflix.vms.transformer.hollowinput.TranslatedTextValueHollow;
import com.netflix.vms.transformer.hollowinput.VMSHollowInputAPI;
import com.netflix.vms.transformer.hollowoutput.L10NResources;
import com.netflix.vms.transformer.hollowoutput.L10NStrings;
import com.netflix.vms.transformer.hollowoutput.NFLocale;
import com.netflix.vms.transformer.index.VMSTransformerIndexer;
import com.netflix.vms.transformer.modules.AbstractTransformModule;
import com.netflix.vms.transformer.util.NFLocaleUtil;

import java.util.HashMap;
import java.util.Map;

public class L10NResourcesModule extends AbstractTransformModule {
    private final VMSHollowInputAPI api;

    public L10NResourcesModule(VMSHollowInputAPI api, TransformerContext ctx, HollowObjectMapper mapper, VMSTransformerIndexer indexer) {
        super(api, ctx, mapper);
        this.api = api;
    }

    @Override
    public void transform() {
        processStoriesSynopsesHollow();
    }

    private void processStoriesSynopsesHollow() {
        for (StoriesSynopsesHollow item : api.getAllStoriesSynopsesHollow()) {
            final int videoId = (int) item._getMovieId();

            { // narrativeText
                final String id = L10nResourceIdLookup.getNarrativeTextId(videoId).toString();
                addL10NResources(id, item._getNarrativeText()._getTranslatedTexts());
            }

            { // hooks
                for (StoriesSynopsesHookHollow hook : item._getHooks()) {
                    String type = hook._getType()._getValue();
                    final String id = L10nResourceIdLookup.getHookTextId(videoId, HookType.toHookType(type)).toString();
                    addL10NResources(id, hook._getTranslatedTexts());
                }
            }
        }
    }

    private void addL10NResources(String id, MapOfTranslatedTextHollow mapOfTranslatedText) {
        L10NResources l10n = new L10NResources();
        l10n.resourceIdStr = id.toCharArray();
        l10n.localizedStrings = processTranslatedText(mapOfTranslatedText);
        mapper.addObject(l10n);
    }

    private Map<NFLocale, L10NStrings> processTranslatedText(MapOfTranslatedTextHollow mapOfTranslatedText) {
        Map<NFLocale, L10NStrings> result = new HashMap<>();

        for (Map.Entry<MapKeyHollow, TranslatedTextValueHollow> entry : mapOfTranslatedText.entrySet()) {
            String locale = entry.getKey()._getValue();
            String value = entry.getValue()._getValue()._getValue();
            result.put(NFLocaleUtil.createNFLocale(locale), new L10NStrings(value));
        }

        return result;
    }
}
