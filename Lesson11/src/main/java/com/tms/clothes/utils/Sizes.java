package com.tms.clothes.utils;

public enum Sizes {
    XXS(32),
    XS(34) {
        @Override
        public String getDescription() {
            return "детский размер";
        }
    },
    S(36),
    M(38),
    L(40);

    private int euroSize;

    Sizes(int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public String getDescription() {
        return "взрослый размер";
    }
}
