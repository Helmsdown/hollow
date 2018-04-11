package com.netflix.vms.transformer.converterpojos;

import com.netflix.hollow.core.write.objectmapper.HollowTypeName;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("all")
@HollowTypeName(name="CharacterArtworkSource")
public class CharacterArtworkSource implements Cloneable {

    public String sourceFileId = null;
    public long characterId = java.lang.Long.MIN_VALUE;
    public boolean isFallback = false;
    public String fallbackSourceFileId = null;
    public int seqNum = java.lang.Integer.MIN_VALUE;
    public int ordinalPriority = java.lang.Integer.MIN_VALUE;
    public String fileImageType = null;
    @HollowTypeName(name="PhaseTagList")
    public List<PhaseTag> phaseTags = null;
    public boolean isSmoky = false;
    public boolean rolloutExclusive = false;
    public ArtworkAttributes attributes = null;
    @HollowTypeName(name="ArtworkLocaleList")
    public List<ArtworkLocale> locales = null;

    public CharacterArtworkSource setSourceFileId(String sourceFileId) {
        this.sourceFileId = sourceFileId;
        return this;
    }
    public CharacterArtworkSource setCharacterId(long characterId) {
        this.characterId = characterId;
        return this;
    }
    public CharacterArtworkSource setIsFallback(boolean isFallback) {
        this.isFallback = isFallback;
        return this;
    }
    public CharacterArtworkSource setFallbackSourceFileId(String fallbackSourceFileId) {
        this.fallbackSourceFileId = fallbackSourceFileId;
        return this;
    }
    public CharacterArtworkSource setSeqNum(int seqNum) {
        this.seqNum = seqNum;
        return this;
    }
    public CharacterArtworkSource setOrdinalPriority(int ordinalPriority) {
        this.ordinalPriority = ordinalPriority;
        return this;
    }
    public CharacterArtworkSource setFileImageType(String fileImageType) {
        this.fileImageType = fileImageType;
        return this;
    }
    public CharacterArtworkSource setPhaseTags(List<PhaseTag> phaseTags) {
        this.phaseTags = phaseTags;
        return this;
    }
    public CharacterArtworkSource setIsSmoky(boolean isSmoky) {
        this.isSmoky = isSmoky;
        return this;
    }
    public CharacterArtworkSource setRolloutExclusive(boolean rolloutExclusive) {
        this.rolloutExclusive = rolloutExclusive;
        return this;
    }
    public CharacterArtworkSource setAttributes(ArtworkAttributes attributes) {
        this.attributes = attributes;
        return this;
    }
    public CharacterArtworkSource setLocales(List<ArtworkLocale> locales) {
        this.locales = locales;
        return this;
    }
    public CharacterArtworkSource addToPhaseTags(PhaseTag phaseTag) {
        if (this.phaseTags == null) {
            this.phaseTags = new ArrayList<PhaseTag>();
        }
        this.phaseTags.add(phaseTag);
        return this;
    }
    public CharacterArtworkSource addToLocales(ArtworkLocale artworkLocale) {
        if (this.locales == null) {
            this.locales = new ArrayList<ArtworkLocale>();
        }
        this.locales.add(artworkLocale);
        return this;
    }
    public boolean equals(Object other) {
        if(other == this)  return true;
        if(!(other instanceof CharacterArtworkSource))
            return false;

        CharacterArtworkSource o = (CharacterArtworkSource) other;
        if(o.sourceFileId == null) {
            if(sourceFileId != null) return false;
        } else if(!o.sourceFileId.equals(sourceFileId)) return false;
        if(o.characterId != characterId) return false;
        if(o.isFallback != isFallback) return false;
        if(o.fallbackSourceFileId == null) {
            if(fallbackSourceFileId != null) return false;
        } else if(!o.fallbackSourceFileId.equals(fallbackSourceFileId)) return false;
        if(o.seqNum != seqNum) return false;
        if(o.ordinalPriority != ordinalPriority) return false;
        if(o.fileImageType == null) {
            if(fileImageType != null) return false;
        } else if(!o.fileImageType.equals(fileImageType)) return false;
        if(o.phaseTags == null) {
            if(phaseTags != null) return false;
        } else if(!o.phaseTags.equals(phaseTags)) return false;
        if(o.isSmoky != isSmoky) return false;
        if(o.rolloutExclusive != rolloutExclusive) return false;
        if(o.attributes == null) {
            if(attributes != null) return false;
        } else if(!o.attributes.equals(attributes)) return false;
        if(o.locales == null) {
            if(locales != null) return false;
        } else if(!o.locales.equals(locales)) return false;
        return true;
    }

    public int hashCode() {
        int hashCode = 1;
        hashCode = hashCode * 31 + (sourceFileId == null ? 1237 : sourceFileId.hashCode());
        hashCode = hashCode * 31 + (int) (characterId ^ (characterId >>> 32));
        hashCode = hashCode * 31 + (isFallback? 1231 : 1237);
        hashCode = hashCode * 31 + (fallbackSourceFileId == null ? 1237 : fallbackSourceFileId.hashCode());
        hashCode = hashCode * 31 + seqNum;
        hashCode = hashCode * 31 + ordinalPriority;
        hashCode = hashCode * 31 + (fileImageType == null ? 1237 : fileImageType.hashCode());
        hashCode = hashCode * 31 + (phaseTags == null ? 1237 : phaseTags.hashCode());
        hashCode = hashCode * 31 + (isSmoky? 1231 : 1237);
        hashCode = hashCode * 31 + (rolloutExclusive? 1231 : 1237);
        hashCode = hashCode * 31 + (attributes == null ? 1237 : attributes.hashCode());
        hashCode = hashCode * 31 + (locales == null ? 1237 : locales.hashCode());
        return hashCode;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("CharacterArtworkSource{");
        builder.append("sourceFileId=").append(sourceFileId);
        builder.append(",characterId=").append(characterId);
        builder.append(",isFallback=").append(isFallback);
        builder.append(",fallbackSourceFileId=").append(fallbackSourceFileId);
        builder.append(",seqNum=").append(seqNum);
        builder.append(",ordinalPriority=").append(ordinalPriority);
        builder.append(",fileImageType=").append(fileImageType);
        builder.append(",phaseTags=").append(phaseTags);
        builder.append(",isSmoky=").append(isSmoky);
        builder.append(",rolloutExclusive=").append(rolloutExclusive);
        builder.append(",attributes=").append(attributes);
        builder.append(",locales=").append(locales);
        builder.append("}");
        return builder.toString();
    }

    public CharacterArtworkSource clone() {
        try {
            CharacterArtworkSource clone = (CharacterArtworkSource)super.clone();
            return clone;
        } catch (CloneNotSupportedException cnse) { throw new RuntimeException(cnse); }
    }

}