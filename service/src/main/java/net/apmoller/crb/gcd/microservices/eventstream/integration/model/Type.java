package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

public enum Type {
    Confirm_Shipment_Closed_TPDOC,
    Schedule_Shipment_Closed_TPDOC,
    Issue_Verify_Copy_of_TPDOC_Closed,
    Issue_Amended_Verify_Copy_of_TPDOC_Closed,
    Shipment_Merge_or_Split,
    Import_Party_Code_Changed,
    Related_Seal_Number_Changed,
    Complete_House_Manifest,
    Issue_Original_TPDOC_Closed,
    TPDOC_Removed,
    LINK,
    AMEND,
    UNLINK,
    CREATE,
    PORTCALL_AMEND,
    PORTCALL_DELETE;
}
