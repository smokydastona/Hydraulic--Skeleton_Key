package org.geysermc.hydraulic.compat.runtime;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BlockUseActionPlanTest {
    @Test
    void compilesExplicitHeldItemInsertion() {
        BlockUseActionPlan plan = BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "insert_held_item",
            "interaction.block_use.slot", "0",
            "interaction.block_use.count", "1",
            "interaction.block_use.side", "up"
        ));

        assertEquals(new BlockUseActionPlan(BlockUseActionPlan.Action.INSERT_HELD_ITEM, 0, 1, "up", null), plan);
    }

    @Test
    void defaultsTransferCountToOne() {
        BlockUseActionPlan plan = BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "insert_held_item",
            "interaction.block_use.slot", "2"
        ));

        assertEquals(1, plan.count());
    }

    @Test
    void rejectsUnknownOrMalformedActions() {
        assertNull(BlockUseActionPlan.from(Map.of()));
        assertNull(BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "unknown",
            "interaction.block_use.slot", "0"
        )));
        assertNull(BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "insert_held_item",
            "interaction.block_use.slot", "-1"
        )));
        assertNull(BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "insert_held_item",
            "interaction.block_use.slot", "0",
            "interaction.block_use.count", "65"
        )));
    }

    @Test
    void compilesOptionalExtractCounterpart() {
        BlockUseActionPlan plan = BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "insert_held_item",
            "interaction.block_use.slot", "0",
            "interaction.block_use.extract_slot", "1",
            "interaction.block_use.extract_item", "minecraft:stone",
            "interaction.block_use.extract_count", "4",
            "interaction.block_use.extract_side", "down"
        ));

        assertEquals(new BlockUseActionPlan.ExtractAction(1, "minecraft:stone", 4, "down"), plan.extract());
    }

    @Test
    void extractDefaultsCountToOneAndOmitsWhenIncomplete() {
        BlockUseActionPlan withDefaultCount = BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "insert_held_item",
            "interaction.block_use.slot", "0",
            "interaction.block_use.extract_slot", "1",
            "interaction.block_use.extract_item", "minecraft:stone"
        ));
        assertEquals(new BlockUseActionPlan.ExtractAction(1, "minecraft:stone", 1, null), withDefaultCount.extract());

        BlockUseActionPlan missingItem = BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "insert_held_item",
            "interaction.block_use.slot", "0",
            "interaction.block_use.extract_slot", "1"
        ));
        assertNull(missingItem.extract());

        BlockUseActionPlan missingSlot = BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "insert_held_item",
            "interaction.block_use.slot", "0",
            "interaction.block_use.extract_item", "minecraft:stone"
        ));
        assertNull(missingSlot.extract());
    }

    @Test
    void omitsMalformedExtractItemIdentifier() {
        BlockUseActionPlan plan = BlockUseActionPlan.from(Map.of(
            "interaction.block_use.action", "insert_held_item",
            "interaction.block_use.slot", "0",
            "interaction.block_use.extract_slot", "1",
            "interaction.block_use.extract_item", "not an identifier"
        ));

        assertNull(plan.extract());
    }
}