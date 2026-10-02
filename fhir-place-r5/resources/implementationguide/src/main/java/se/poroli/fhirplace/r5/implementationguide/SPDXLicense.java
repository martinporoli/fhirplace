package se.poroli.fhirplace.r5.implementationguide;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The license that applies to an Implementation Guide (using an SPDX license Identifiers, or 'not-open-source').
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/spdx-license">FHIR R5 SPDXLicense</a>
 */
public enum SPDXLicense implements CodedEnum {

    /** Not an open source license. */
    NOT_OPEN_SOURCE("not-open-source", "Not open source"),

    /** BSD Zero Clause License. */
    CODE_0_BSD("0BSD", "BSD Zero Clause License"),

    /** Attribution Assurance License. */
    AAL("AAL", "Attribution Assurance License"),

    /** Abstyles License. */
    ABSTYLES("Abstyles", "Abstyles License"),

    /** Adobe Systems Incorporated Source Code License Agreement. */
    ADOBE_2006("Adobe-2006", "Adobe Systems Incorporated Source Code License Agreement"),

    /** Adobe Glyph List License. */
    ADOBE_GLYPH("Adobe-Glyph", "Adobe Glyph List License"),

    /** Amazon Digital Services License. */
    ADSL("ADSL", "Amazon Digital Services License"),

    /** Academic Free License v1.1. */
    AFL_1_1("AFL-1.1", "Academic Free License v1.1"),

    /** Academic Free License v1.2. */
    AFL_1_2("AFL-1.2", "Academic Free License v1.2"),

    /** Academic Free License v2.0. */
    AFL_2_0("AFL-2.0", "Academic Free License v2.0"),

    /** Academic Free License v2.1. */
    AFL_2_1("AFL-2.1", "Academic Free License v2.1"),

    /** Academic Free License v3.0. */
    AFL_3_0("AFL-3.0", "Academic Free License v3.0"),

    /** Afmparse License. */
    AFMPARSE("Afmparse", "Afmparse License"),

    /** Affero General Public License v1.0 only. */
    AGPL_1_0_ONLY("AGPL-1.0-only", "Affero General Public License v1.0 only"),

    /** Affero General Public License v1.0 or later. */
    AGPL_1_0_OR_LATER("AGPL-1.0-or-later", "Affero General Public License v1.0 or later"),

    /** GNU Affero General Public License v3.0 only. */
    AGPL_3_0_ONLY("AGPL-3.0-only", "GNU Affero General Public License v3.0 only"),

    /** GNU Affero General Public License v3.0 or later. */
    AGPL_3_0_OR_LATER("AGPL-3.0-or-later", "GNU Affero General Public License v3.0 or later"),

    /** Aladdin Free Public License. */
    ALADDIN("Aladdin", "Aladdin Free Public License"),

    /** AMD's plpa_map.c License. */
    AMDPLPA("AMDPLPA", "AMD's plpa_map.c License"),

    /** Apple MIT License. */
    AML("AML", "Apple MIT License"),

    /** Academy of Motion Picture Arts and Sciences BSD. */
    AMPAS("AMPAS", "Academy of Motion Picture Arts and Sciences BSD"),

    /** ANTLR Software Rights Notice. */
    ANTLR_PD("ANTLR-PD", "ANTLR Software Rights Notice"),

    /** Apache License 1.0. */
    APACHE_1_0("Apache-1.0", "Apache License 1.0"),

    /** Apache License 1.1. */
    APACHE_1_1("Apache-1.1", "Apache License 1.1"),

    /** Apache License 2.0. */
    APACHE_2_0("Apache-2.0", "Apache License 2.0"),

    /** Adobe Postscript AFM License. */
    APAFML("APAFML", "Adobe Postscript AFM License"),

    /** Adaptive Public License 1.0. */
    APL_1_0("APL-1.0", "Adaptive Public License 1.0"),

    /** Apple Public Source License 1.0. */
    APSL_1_0("APSL-1.0", "Apple Public Source License 1.0"),

    /** Apple Public Source License 1.1. */
    APSL_1_1("APSL-1.1", "Apple Public Source License 1.1"),

    /** Apple Public Source License 1.2. */
    APSL_1_2("APSL-1.2", "Apple Public Source License 1.2"),

    /** Apple Public Source License 2.0. */
    APSL_2_0("APSL-2.0", "Apple Public Source License 2.0"),

    /** Artistic License 1.0 w/clause 8. */
    ARTISTIC_1_0_CL8("Artistic-1.0-cl8", "Artistic License 1.0 w/clause 8"),

    /** Artistic License 1.0 (Perl). */
    ARTISTIC_1_0_PERL("Artistic-1.0-Perl", "Artistic License 1.0 (Perl)"),

    /** Artistic License 1.0. */
    ARTISTIC_1_0("Artistic-1.0", "Artistic License 1.0"),

    /** Artistic License 2.0. */
    ARTISTIC_2_0("Artistic-2.0", "Artistic License 2.0"),

    /** Bahyph License. */
    BAHYPH("Bahyph", "Bahyph License"),

    /** Barr License. */
    BARR("Barr", "Barr License"),

    /** Beerware License. */
    BEERWARE("Beerware", "Beerware License"),

    /** BitTorrent Open Source License v1.0. */
    BIT_TORRENT_1_0("BitTorrent-1.0", "BitTorrent Open Source License v1.0"),

    /** BitTorrent Open Source License v1.1. */
    BIT_TORRENT_1_1("BitTorrent-1.1", "BitTorrent Open Source License v1.1"),

    /** Borceux license. */
    BORCEUX("Borceux", "Borceux license"),

    /** BSD 1-Clause License. */
    BSD_1_CLAUSE("BSD-1-Clause", "BSD 1-Clause License"),

    /** BSD 2-Clause FreeBSD License. */
    BSD_2_CLAUSE_FREE_BSD("BSD-2-Clause-FreeBSD", "BSD 2-Clause FreeBSD License"),

    /** BSD 2-Clause NetBSD License. */
    BSD_2_CLAUSE_NET_BSD("BSD-2-Clause-NetBSD", "BSD 2-Clause NetBSD License"),

    /** BSD-2-Clause Plus Patent License. */
    BSD_2_CLAUSE_PATENT("BSD-2-Clause-Patent", "BSD-2-Clause Plus Patent License"),

    /** BSD 2-Clause "Simplified" License. */
    BSD_2_CLAUSE("BSD-2-Clause", "BSD 2-Clause \"Simplified\" License"),

    /** BSD with attribution. */
    BSD_3_CLAUSE_ATTRIBUTION("BSD-3-Clause-Attribution", "BSD with attribution"),

    /** BSD 3-Clause Clear License. */
    BSD_3_CLAUSE_CLEAR("BSD-3-Clause-Clear", "BSD 3-Clause Clear License"),

    /** Lawrence Berkeley National Labs BSD variant license. */
    BSD_3_CLAUSE_LBNL("BSD-3-Clause-LBNL", "Lawrence Berkeley National Labs BSD variant license"),

    /** BSD 3-Clause No Nuclear License 2014. */
    BSD_3_CLAUSE_NO_NUCLEAR_LICENSE_2014(
            "BSD-3-Clause-No-Nuclear-License-2014",
            "BSD 3-Clause No Nuclear License 2014"),

    /** BSD 3-Clause No Nuclear License. */
    BSD_3_CLAUSE_NO_NUCLEAR_LICENSE("BSD-3-Clause-No-Nuclear-License", "BSD 3-Clause No Nuclear License"),

    /** BSD 3-Clause No Nuclear Warranty. */
    BSD_3_CLAUSE_NO_NUCLEAR_WARRANTY("BSD-3-Clause-No-Nuclear-Warranty", "BSD 3-Clause No Nuclear Warranty"),

    /** BSD 3-Clause "New" or "Revised" License. */
    BSD_3_CLAUSE("BSD-3-Clause", "BSD 3-Clause \"New\" or \"Revised\" License"),

    /** BSD-4-Clause (University of California-Specific). */
    BSD_4_CLAUSE_UC("BSD-4-Clause-UC", "BSD-4-Clause (University of California-Specific)"),

    /** BSD 4-Clause "Original" or "Old" License. */
    BSD_4_CLAUSE("BSD-4-Clause", "BSD 4-Clause \"Original\" or \"Old\" License"),

    /** BSD Protection License. */
    BSD_PROTECTION("BSD-Protection", "BSD Protection License"),

    /** BSD Source Code Attribution. */
    BSD_SOURCE_CODE("BSD-Source-Code", "BSD Source Code Attribution"),

    /** Boost Software License 1.0. */
    BSL_1_0("BSL-1.0", "Boost Software License 1.0"),

    /** bzip2 and libbzip2 License v1.0.5. */
    BZIP2_1_0_5("bzip2-1.0.5", "bzip2 and libbzip2 License v1.0.5"),

    /** bzip2 and libbzip2 License v1.0.6. */
    BZIP2_1_0_6("bzip2-1.0.6", "bzip2 and libbzip2 License v1.0.6"),

    /** Caldera License. */
    CALDERA("Caldera", "Caldera License"),

    /** Computer Associates Trusted Open Source License 1.1. */
    CATOSL_1_1("CATOSL-1.1", "Computer Associates Trusted Open Source License 1.1"),

    /** Creative Commons Attribution 1.0 Generic. */
    CC_BY_1_0("CC-BY-1.0", "Creative Commons Attribution 1.0 Generic"),

    /** Creative Commons Attribution 2.0 Generic. */
    CC_BY_2_0("CC-BY-2.0", "Creative Commons Attribution 2.0 Generic"),

    /** Creative Commons Attribution 2.5 Generic. */
    CC_BY_2_5("CC-BY-2.5", "Creative Commons Attribution 2.5 Generic"),

    /** Creative Commons Attribution 3.0 Unported. */
    CC_BY_3_0("CC-BY-3.0", "Creative Commons Attribution 3.0 Unported"),

    /** Creative Commons Attribution 4.0 International. */
    CC_BY_4_0("CC-BY-4.0", "Creative Commons Attribution 4.0 International"),

    /** Creative Commons Attribution Non Commercial 1.0 Generic. */
    CC_BY_NC_1_0("CC-BY-NC-1.0", "Creative Commons Attribution Non Commercial 1.0 Generic"),

    /** Creative Commons Attribution Non Commercial 2.0 Generic. */
    CC_BY_NC_2_0("CC-BY-NC-2.0", "Creative Commons Attribution Non Commercial 2.0 Generic"),

    /** Creative Commons Attribution Non Commercial 2.5 Generic. */
    CC_BY_NC_2_5("CC-BY-NC-2.5", "Creative Commons Attribution Non Commercial 2.5 Generic"),

    /** Creative Commons Attribution Non Commercial 3.0 Unported. */
    CC_BY_NC_3_0("CC-BY-NC-3.0", "Creative Commons Attribution Non Commercial 3.0 Unported"),

    /** Creative Commons Attribution Non Commercial 4.0 International. */
    CC_BY_NC_4_0("CC-BY-NC-4.0", "Creative Commons Attribution Non Commercial 4.0 International"),

    /** Creative Commons Attribution Non Commercial No Derivatives 1.0 Generic. */
    CC_BY_NC_ND_1_0("CC-BY-NC-ND-1.0", "Creative Commons Attribution Non Commercial No Derivatives 1.0 Generic"),

    /** Creative Commons Attribution Non Commercial No Derivatives 2.0 Generic. */
    CC_BY_NC_ND_2_0("CC-BY-NC-ND-2.0", "Creative Commons Attribution Non Commercial No Derivatives 2.0 Generic"),

    /** Creative Commons Attribution Non Commercial No Derivatives 2.5 Generic. */
    CC_BY_NC_ND_2_5("CC-BY-NC-ND-2.5", "Creative Commons Attribution Non Commercial No Derivatives 2.5 Generic"),

    /** Creative Commons Attribution Non Commercial No Derivatives 3.0 Unported. */
    CC_BY_NC_ND_3_0("CC-BY-NC-ND-3.0", "Creative Commons Attribution Non Commercial No Derivatives 3.0 Unported"),

    /** Creative Commons Attribution Non Commercial No Derivatives 4.0 International. */
    CC_BY_NC_ND_4_0(
            "CC-BY-NC-ND-4.0",
            "Creative Commons Attribution Non Commercial No Derivatives 4.0 International"),

    /** Creative Commons Attribution Non Commercial Share Alike 1.0 Generic. */
    CC_BY_NC_SA_1_0("CC-BY-NC-SA-1.0", "Creative Commons Attribution Non Commercial Share Alike 1.0 Generic"),

    /** Creative Commons Attribution Non Commercial Share Alike 2.0 Generic. */
    CC_BY_NC_SA_2_0("CC-BY-NC-SA-2.0", "Creative Commons Attribution Non Commercial Share Alike 2.0 Generic"),

    /** Creative Commons Attribution Non Commercial Share Alike 2.5 Generic. */
    CC_BY_NC_SA_2_5("CC-BY-NC-SA-2.5", "Creative Commons Attribution Non Commercial Share Alike 2.5 Generic"),

    /** Creative Commons Attribution Non Commercial Share Alike 3.0 Unported. */
    CC_BY_NC_SA_3_0("CC-BY-NC-SA-3.0", "Creative Commons Attribution Non Commercial Share Alike 3.0 Unported"),

    /** Creative Commons Attribution Non Commercial Share Alike 4.0 International. */
    CC_BY_NC_SA_4_0("CC-BY-NC-SA-4.0", "Creative Commons Attribution Non Commercial Share Alike 4.0 International"),

    /** Creative Commons Attribution No Derivatives 1.0 Generic. */
    CC_BY_ND_1_0("CC-BY-ND-1.0", "Creative Commons Attribution No Derivatives 1.0 Generic"),

    /** Creative Commons Attribution No Derivatives 2.0 Generic. */
    CC_BY_ND_2_0("CC-BY-ND-2.0", "Creative Commons Attribution No Derivatives 2.0 Generic"),

    /** Creative Commons Attribution No Derivatives 2.5 Generic. */
    CC_BY_ND_2_5("CC-BY-ND-2.5", "Creative Commons Attribution No Derivatives 2.5 Generic"),

    /** Creative Commons Attribution No Derivatives 3.0 Unported. */
    CC_BY_ND_3_0("CC-BY-ND-3.0", "Creative Commons Attribution No Derivatives 3.0 Unported"),

    /** Creative Commons Attribution No Derivatives 4.0 International. */
    CC_BY_ND_4_0("CC-BY-ND-4.0", "Creative Commons Attribution No Derivatives 4.0 International"),

    /** Creative Commons Attribution Share Alike 1.0 Generic. */
    CC_BY_SA_1_0("CC-BY-SA-1.0", "Creative Commons Attribution Share Alike 1.0 Generic"),

    /** Creative Commons Attribution Share Alike 2.0 Generic. */
    CC_BY_SA_2_0("CC-BY-SA-2.0", "Creative Commons Attribution Share Alike 2.0 Generic"),

    /** Creative Commons Attribution Share Alike 2.5 Generic. */
    CC_BY_SA_2_5("CC-BY-SA-2.5", "Creative Commons Attribution Share Alike 2.5 Generic"),

    /** Creative Commons Attribution Share Alike 3.0 Unported. */
    CC_BY_SA_3_0("CC-BY-SA-3.0", "Creative Commons Attribution Share Alike 3.0 Unported"),

    /** Creative Commons Attribution Share Alike 4.0 International. */
    CC_BY_SA_4_0("CC-BY-SA-4.0", "Creative Commons Attribution Share Alike 4.0 International"),

    /** Creative Commons Zero v1.0 Universal. */
    CC0_1_0("CC0-1.0", "Creative Commons Zero v1.0 Universal"),

    /** Common Development and Distribution License 1.0. */
    CDDL_1_0("CDDL-1.0", "Common Development and Distribution License 1.0"),

    /** Common Development and Distribution License 1.1. */
    CDDL_1_1("CDDL-1.1", "Common Development and Distribution License 1.1"),

    /** Community Data License Agreement Permissive 1.0. */
    CDLA_PERMISSIVE_1_0("CDLA-Permissive-1.0", "Community Data License Agreement Permissive 1.0"),

    /** Community Data License Agreement Sharing 1.0. */
    CDLA_SHARING_1_0("CDLA-Sharing-1.0", "Community Data License Agreement Sharing 1.0"),

    /** CeCILL Free Software License Agreement v1.0. */
    CECILL_1_0("CECILL-1.0", "CeCILL Free Software License Agreement v1.0"),

    /** CeCILL Free Software License Agreement v1.1. */
    CECILL_1_1("CECILL-1.1", "CeCILL Free Software License Agreement v1.1"),

    /** CeCILL Free Software License Agreement v2.0. */
    CECILL_2_0("CECILL-2.0", "CeCILL Free Software License Agreement v2.0"),

    /** CeCILL Free Software License Agreement v2.1. */
    CECILL_2_1("CECILL-2.1", "CeCILL Free Software License Agreement v2.1"),

    /** CeCILL-B Free Software License Agreement. */
    CECILL_B("CECILL-B", "CeCILL-B Free Software License Agreement"),

    /** CeCILL-C Free Software License Agreement. */
    CECILL_C("CECILL-C", "CeCILL-C Free Software License Agreement"),

    /** Clarified Artistic License. */
    CL_ARTISTIC("ClArtistic", "Clarified Artistic License"),

    /** CNRI Jython License. */
    CNRI_JYTHON("CNRI-Jython", "CNRI Jython License"),

    /** CNRI Python Open Source GPL Compatible License Agreement. */
    CNRI_PYTHON_GPL_COMPATIBLE(
            "CNRI-Python-GPL-Compatible",
            "CNRI Python Open Source GPL Compatible License Agreement"),

    /** CNRI Python License. */
    CNRI_PYTHON("CNRI-Python", "CNRI Python License"),

    /** Condor Public License v1.1. */
    CONDOR_1_1("Condor-1.1", "Condor Public License v1.1"),

    /** Common Public Attribution License 1.0. */
    CPAL_1_0("CPAL-1.0", "Common Public Attribution License 1.0"),

    /** Common Public License 1.0. */
    CPL_1_0("CPL-1.0", "Common Public License 1.0"),

    /** Code Project Open License 1.02. */
    CPOL_1_02("CPOL-1.02", "Code Project Open License 1.02"),

    /** Crossword License. */
    CROSSWORD("Crossword", "Crossword License"),

    /** CrystalStacker License. */
    CRYSTAL_STACKER("CrystalStacker", "CrystalStacker License"),

    /** CUA Office Public License v1.0. */
    CUA_OPL_1_0("CUA-OPL-1.0", "CUA Office Public License v1.0"),

    /** Cube License. */
    CUBE("Cube", "Cube License"),

    /** curl License. */
    CURL("curl", "curl License"),

    /** Deutsche Freie Software Lizenz. */
    D_FSL_1_0("D-FSL-1.0", "Deutsche Freie Software Lizenz"),

    /** diffmark license. */
    DIFFMARK("diffmark", "diffmark license"),

    /** DOC License. */
    DOC("DOC", "DOC License"),

    /** Dotseqn License. */
    DOTSEQN("Dotseqn", "Dotseqn License"),

    /** DSDP License. */
    DSDP("DSDP", "DSDP License"),

    /** dvipdfm License. */
    DVIPDFM("dvipdfm", "dvipdfm License"),

    /** Educational Community License v1.0. */
    ECL_1_0("ECL-1.0", "Educational Community License v1.0"),

    /** Educational Community License v2.0. */
    ECL_2_0("ECL-2.0", "Educational Community License v2.0"),

    /** Eiffel Forum License v1.0. */
    EFL_1_0("EFL-1.0", "Eiffel Forum License v1.0"),

    /** Eiffel Forum License v2.0. */
    EFL_2_0("EFL-2.0", "Eiffel Forum License v2.0"),

    /** eGenix.com Public License 1.1.0. */
    E_GENIX("eGenix", "eGenix.com Public License 1.1.0"),

    /** Entessa Public License v1.0. */
    ENTESSA("Entessa", "Entessa Public License v1.0"),

    /** Eclipse Public License 1.0. */
    EPL_1_0("EPL-1.0", "Eclipse Public License 1.0"),

    /** Eclipse Public License 2.0. */
    EPL_2_0("EPL-2.0", "Eclipse Public License 2.0"),

    /** Erlang Public License v1.1. */
    ERL_PL_1_1("ErlPL-1.1", "Erlang Public License v1.1"),

    /** EU DataGrid Software License. */
    EUDATAGRID("EUDatagrid", "EU DataGrid Software License"),

    /** European Union Public License 1.0. */
    EUPL_1_0("EUPL-1.0", "European Union Public License 1.0"),

    /** European Union Public License 1.1. */
    EUPL_1_1("EUPL-1.1", "European Union Public License 1.1"),

    /** European Union Public License 1.2. */
    EUPL_1_2("EUPL-1.2", "European Union Public License 1.2"),

    /** Eurosym License. */
    EUROSYM("Eurosym", "Eurosym License"),

    /** Fair License. */
    FAIR("Fair", "Fair License"),

    /** Frameworx Open License 1.0. */
    FRAMEWORX_1_0("Frameworx-1.0", "Frameworx Open License 1.0"),

    /** FreeImage Public License v1.0. */
    FREE_IMAGE("FreeImage", "FreeImage Public License v1.0"),

    /** FSF All Permissive License. */
    FSFAP("FSFAP", "FSF All Permissive License"),

    /** FSF Unlimited License. */
    FSFUL("FSFUL", "FSF Unlimited License"),

    /** FSF Unlimited License (with License Retention). */
    FSFULLR("FSFULLR", "FSF Unlimited License (with License Retention)"),

    /** Freetype Project License. */
    FTL("FTL", "Freetype Project License"),

    /** GNU Free Documentation License v1.1 only. */
    GFDL_1_1_ONLY("GFDL-1.1-only", "GNU Free Documentation License v1.1 only"),

    /** GNU Free Documentation License v1.1 or later. */
    GFDL_1_1_OR_LATER("GFDL-1.1-or-later", "GNU Free Documentation License v1.1 or later"),

    /** GNU Free Documentation License v1.2 only. */
    GFDL_1_2_ONLY("GFDL-1.2-only", "GNU Free Documentation License v1.2 only"),

    /** GNU Free Documentation License v1.2 or later. */
    GFDL_1_2_OR_LATER("GFDL-1.2-or-later", "GNU Free Documentation License v1.2 or later"),

    /** GNU Free Documentation License v1.3 only. */
    GFDL_1_3_ONLY("GFDL-1.3-only", "GNU Free Documentation License v1.3 only"),

    /** GNU Free Documentation License v1.3 or later. */
    GFDL_1_3_OR_LATER("GFDL-1.3-or-later", "GNU Free Documentation License v1.3 or later"),

    /** Giftware License. */
    GIFTWARE("Giftware", "Giftware License"),

    /** GL2PS License. */
    GL2_PS("GL2PS", "GL2PS License"),

    /** 3dfx Glide License. */
    GLIDE("Glide", "3dfx Glide License"),

    /** Glulxe License. */
    GLULXE("Glulxe", "Glulxe License"),

    /** gnuplot License. */
    GNUPLOT("gnuplot", "gnuplot License"),

    /** GNU General Public License v1.0 only. */
    GPL_1_0_ONLY("GPL-1.0-only", "GNU General Public License v1.0 only"),

    /** GNU General Public License v1.0 or later. */
    GPL_1_0_OR_LATER("GPL-1.0-or-later", "GNU General Public License v1.0 or later"),

    /** GNU General Public License v2.0 only. */
    GPL_2_0_ONLY("GPL-2.0-only", "GNU General Public License v2.0 only"),

    /** GNU General Public License v2.0 or later. */
    GPL_2_0_OR_LATER("GPL-2.0-or-later", "GNU General Public License v2.0 or later"),

    /** GNU General Public License v3.0 only. */
    GPL_3_0_ONLY("GPL-3.0-only", "GNU General Public License v3.0 only"),

    /** GNU General Public License v3.0 or later. */
    GPL_3_0_OR_LATER("GPL-3.0-or-later", "GNU General Public License v3.0 or later"),

    /** gSOAP Public License v1.3b. */
    G_SOAP_1_3B("gSOAP-1.3b", "gSOAP Public License v1.3b"),

    /** Haskell Language Report License. */
    HASKELL_REPORT("HaskellReport", "Haskell Language Report License"),

    /** Historical Permission Notice and Disclaimer. */
    HPND("HPND", "Historical Permission Notice and Disclaimer"),

    /** IBM PowerPC Initialization and Boot Software. */
    IBM_PIBS("IBM-pibs", "IBM PowerPC Initialization and Boot Software"),

    /** ICU License. */
    ICU("ICU", "ICU License"),

    /** Independent JPEG Group License. */
    IJG("IJG", "Independent JPEG Group License"),

    /** ImageMagick License. */
    IMAGE_MAGICK("ImageMagick", "ImageMagick License"),

    /** iMatix Standard Function Library Agreement. */
    I_MATIX("iMatix", "iMatix Standard Function Library Agreement"),

    /** Imlib2 License. */
    IMLIB2("Imlib2", "Imlib2 License"),

    /** Info-ZIP License. */
    INFO_ZIP("Info-ZIP", "Info-ZIP License"),

    /** Intel ACPI Software License Agreement. */
    INTEL_ACPI("Intel-ACPI", "Intel ACPI Software License Agreement"),

    /** Intel Open Source License. */
    INTEL("Intel", "Intel Open Source License"),

    /** Interbase Public License v1.0. */
    INTERBASE_1_0("Interbase-1.0", "Interbase Public License v1.0"),

    /** IPA Font License. */
    IPA("IPA", "IPA Font License"),

    /** IBM Public License v1.0. */
    IPL_1_0("IPL-1.0", "IBM Public License v1.0"),

    /** ISC License. */
    ISC("ISC", "ISC License"),

    /** JasPer License. */
    JAS_PER_2_0("JasPer-2.0", "JasPer License"),

    /** JSON License. */
    JSON("JSON", "JSON License"),

    /** Licence Art Libre 1.2. */
    LAL_1_2("LAL-1.2", "Licence Art Libre 1.2"),

    /** Licence Art Libre 1.3. */
    LAL_1_3("LAL-1.3", "Licence Art Libre 1.3"),

    /** Latex2e License. */
    LATEX2E("Latex2e", "Latex2e License"),

    /** Leptonica License. */
    LEPTONICA("Leptonica", "Leptonica License"),

    /** GNU Library General Public License v2 only. */
    LGPL_2_0_ONLY("LGPL-2.0-only", "GNU Library General Public License v2 only"),

    /** GNU Library General Public License v2 or later. */
    LGPL_2_0_OR_LATER("LGPL-2.0-or-later", "GNU Library General Public License v2 or later"),

    /** GNU Lesser General Public License v2.1 only. */
    LGPL_2_1_ONLY("LGPL-2.1-only", "GNU Lesser General Public License v2.1 only"),

    /** GNU Lesser General Public License v2.1 or later. */
    LGPL_2_1_OR_LATER("LGPL-2.1-or-later", "GNU Lesser General Public License v2.1 or later"),

    /** GNU Lesser General Public License v3.0 only. */
    LGPL_3_0_ONLY("LGPL-3.0-only", "GNU Lesser General Public License v3.0 only"),

    /** GNU Lesser General Public License v3.0 or later. */
    LGPL_3_0_OR_LATER("LGPL-3.0-or-later", "GNU Lesser General Public License v3.0 or later"),

    /** Lesser General Public License For Linguistic Resources. */
    LGPLLR("LGPLLR", "Lesser General Public License For Linguistic Resources"),

    /** libpng License. */
    LIBPNG("Libpng", "libpng License"),

    /** libtiff License. */
    LIBTIFF("libtiff", "libtiff License"),

    /** Licence Libre du Québec – Permissive version 1.1. */
    LI_LI_Q_P_1_1("LiLiQ-P-1.1", "Licence Libre du Québec – Permissive version 1.1"),

    /** Licence Libre du Québec – Réciprocité version 1.1. */
    LI_LI_Q_R_1_1("LiLiQ-R-1.1", "Licence Libre du Québec – Réciprocité version 1.1"),

    /** Licence Libre du Québec – Réciprocité forte version 1.1. */
    LI_LI_Q_RPLUS_1_1("LiLiQ-Rplus-1.1", "Licence Libre du Québec – Réciprocité forte version 1.1"),

    /** Linux Kernel Variant of OpenIB.org license. */
    LINUX_OPEN_IB("Linux-OpenIB", "Linux Kernel Variant of OpenIB.org license"),

    /** Lucent Public License Version 1.0. */
    LPL_1_0("LPL-1.0", "Lucent Public License Version 1.0"),

    /** Lucent Public License v1.02. */
    LPL_1_02("LPL-1.02", "Lucent Public License v1.02"),

    /** LaTeX Project Public License v1.0. */
    LPPL_1_0("LPPL-1.0", "LaTeX Project Public License v1.0"),

    /** LaTeX Project Public License v1.1. */
    LPPL_1_1("LPPL-1.1", "LaTeX Project Public License v1.1"),

    /** LaTeX Project Public License v1.2. */
    LPPL_1_2("LPPL-1.2", "LaTeX Project Public License v1.2"),

    /** LaTeX Project Public License v1.3a. */
    LPPL_1_3A("LPPL-1.3a", "LaTeX Project Public License v1.3a"),

    /** LaTeX Project Public License v1.3c. */
    LPPL_1_3C("LPPL-1.3c", "LaTeX Project Public License v1.3c"),

    /** MakeIndex License. */
    MAKE_INDEX("MakeIndex", "MakeIndex License"),

    /** MirOS License. */
    MIR_OS("MirOS", "MirOS License"),

    /** MIT No Attribution. */
    MIT_0("MIT-0", "MIT No Attribution"),

    /** Enlightenment License (e16). */
    MIT_ADVERTISING("MIT-advertising", "Enlightenment License (e16)"),

    /** CMU License. */
    MIT_CMU("MIT-CMU", "CMU License"),

    /** enna License. */
    MIT_ENNA("MIT-enna", "enna License"),

    /** feh License. */
    MIT_FEH("MIT-feh", "feh License"),

    /** MIT License. */
    MIT("MIT", "MIT License"),

    /** MIT +no-false-attribs license. */
    MITNFA("MITNFA", "MIT +no-false-attribs license"),

    /** Motosoto License. */
    MOTOSOTO("Motosoto", "Motosoto License"),

    /** mpich2 License. */
    MPICH2("mpich2", "mpich2 License"),

    /** Mozilla Public License 1.0. */
    MPL_1_0("MPL-1.0", "Mozilla Public License 1.0"),

    /** Mozilla Public License 1.1. */
    MPL_1_1("MPL-1.1", "Mozilla Public License 1.1"),

    /** Mozilla Public License 2.0 (no copyleft exception). */
    MPL_2_0_NO_COPYLEFT_EXCEPTION(
            "MPL-2.0-no-copyleft-exception",
            "Mozilla Public License 2.0 (no copyleft exception)"),

    /** Mozilla Public License 2.0. */
    MPL_2_0("MPL-2.0", "Mozilla Public License 2.0"),

    /** Microsoft Public License. */
    MS_PL("MS-PL", "Microsoft Public License"),

    /** Microsoft Reciprocal License. */
    MS_RL("MS-RL", "Microsoft Reciprocal License"),

    /** Matrix Template Library License. */
    MTLL("MTLL", "Matrix Template Library License"),

    /** Multics License. */
    MULTICS("Multics", "Multics License"),

    /** Mup License. */
    MUP("Mup", "Mup License"),

    /** NASA Open Source Agreement 1.3. */
    NASA_1_3("NASA-1.3", "NASA Open Source Agreement 1.3"),

    /** Naumen Public License. */
    NAUMEN("Naumen", "Naumen Public License"),

    /** Net Boolean Public License v1. */
    NBPL_1_0("NBPL-1.0", "Net Boolean Public License v1"),

    /** University of Illinois/NCSA Open Source License. */
    NCSA("NCSA", "University of Illinois/NCSA Open Source License"),

    /** Net-SNMP License. */
    NET_SNMP("Net-SNMP", "Net-SNMP License"),

    /** NetCDF license. */
    NET_CDF("NetCDF", "NetCDF license"),

    /** Newsletr License. */
    NEWSLETR("Newsletr", "Newsletr License"),

    /** Nethack General Public License. */
    NGPL("NGPL", "Nethack General Public License"),

    /** Norwegian Licence for Open Government Data. */
    NLOD_1_0("NLOD-1.0", "Norwegian Licence for Open Government Data"),

    /** No Limit Public License. */
    NLPL("NLPL", "No Limit Public License"),

    /** Nokia Open Source License. */
    NOKIA("Nokia", "Nokia Open Source License"),

    /** Netizen Open Source License. */
    NOSL("NOSL", "Netizen Open Source License"),

    /** Noweb License. */
    NOWEB("Noweb", "Noweb License"),

    /** Netscape Public License v1.0. */
    NPL_1_0("NPL-1.0", "Netscape Public License v1.0"),

    /** Netscape Public License v1.1. */
    NPL_1_1("NPL-1.1", "Netscape Public License v1.1"),

    /** Non-Profit Open Software License 3.0. */
    NPOSL_3_0("NPOSL-3.0", "Non-Profit Open Software License 3.0"),

    /** NRL License. */
    NRL("NRL", "NRL License"),

    /** NTP License. */
    NTP("NTP", "NTP License"),

    /** Open CASCADE Technology Public License. */
    OCCT_PL("OCCT-PL", "Open CASCADE Technology Public License"),

    /** OCLC Research Public License 2.0. */
    OCLC_2_0("OCLC-2.0", "OCLC Research Public License 2.0"),

    /** ODC Open Database License v1.0. */
    ODB_L_1_0("ODbL-1.0", "ODC Open Database License v1.0"),

    /** SIL Open Font License 1.0. */
    OFL_1_0("OFL-1.0", "SIL Open Font License 1.0"),

    /** SIL Open Font License 1.1. */
    OFL_1_1("OFL-1.1", "SIL Open Font License 1.1"),

    /** Open Group Test Suite License. */
    OGTSL("OGTSL", "Open Group Test Suite License"),

    /** Open LDAP Public License v1.1. */
    OLDAP_1_1("OLDAP-1.1", "Open LDAP Public License v1.1"),

    /** Open LDAP Public License v1.2. */
    OLDAP_1_2("OLDAP-1.2", "Open LDAP Public License v1.2"),

    /** Open LDAP Public License v1.3. */
    OLDAP_1_3("OLDAP-1.3", "Open LDAP Public License v1.3"),

    /** Open LDAP Public License v1.4. */
    OLDAP_1_4("OLDAP-1.4", "Open LDAP Public License v1.4"),

    /** Open LDAP Public License v2.0.1. */
    OLDAP_2_0_1("OLDAP-2.0.1", "Open LDAP Public License v2.0.1"),

    /** Open LDAP Public License v2.0 (or possibly 2.0A and 2.0B). */
    OLDAP_2_0("OLDAP-2.0", "Open LDAP Public License v2.0 (or possibly 2.0A and 2.0B)"),

    /** Open LDAP Public License v2.1. */
    OLDAP_2_1("OLDAP-2.1", "Open LDAP Public License v2.1"),

    /** Open LDAP Public License v2.2.1. */
    OLDAP_2_2_1("OLDAP-2.2.1", "Open LDAP Public License v2.2.1"),

    /** Open LDAP Public License 2.2.2. */
    OLDAP_2_2_2("OLDAP-2.2.2", "Open LDAP Public License 2.2.2"),

    /** Open LDAP Public License v2.2. */
    OLDAP_2_2("OLDAP-2.2", "Open LDAP Public License v2.2"),

    /** Open LDAP Public License v2.3. */
    OLDAP_2_3("OLDAP-2.3", "Open LDAP Public License v2.3"),

    /** Open LDAP Public License v2.4. */
    OLDAP_2_4("OLDAP-2.4", "Open LDAP Public License v2.4"),

    /** Open LDAP Public License v2.5. */
    OLDAP_2_5("OLDAP-2.5", "Open LDAP Public License v2.5"),

    /** Open LDAP Public License v2.6. */
    OLDAP_2_6("OLDAP-2.6", "Open LDAP Public License v2.6"),

    /** Open LDAP Public License v2.7. */
    OLDAP_2_7("OLDAP-2.7", "Open LDAP Public License v2.7"),

    /** Open LDAP Public License v2.8. */
    OLDAP_2_8("OLDAP-2.8", "Open LDAP Public License v2.8"),

    /** Open Market License. */
    OML("OML", "Open Market License"),

    /** OpenSSL License. */
    OPEN_SSL("OpenSSL", "OpenSSL License"),

    /** Open Public License v1.0. */
    OPL_1_0("OPL-1.0", "Open Public License v1.0"),

    /** OSET Public License version 2.1. */
    OSET_PL_2_1("OSET-PL-2.1", "OSET Public License version 2.1"),

    /** Open Software License 1.0. */
    OSL_1_0("OSL-1.0", "Open Software License 1.0"),

    /** Open Software License 1.1. */
    OSL_1_1("OSL-1.1", "Open Software License 1.1"),

    /** Open Software License 2.0. */
    OSL_2_0("OSL-2.0", "Open Software License 2.0"),

    /** Open Software License 2.1. */
    OSL_2_1("OSL-2.1", "Open Software License 2.1"),

    /** Open Software License 3.0. */
    OSL_3_0("OSL-3.0", "Open Software License 3.0"),

    /** ODC Public Domain Dedication &amp; License 1.0. */
    PDDL_1_0("PDDL-1.0", "ODC Public Domain Dedication & License 1.0"),

    /** PHP License v3.0. */
    PHP_3_0("PHP-3.0", "PHP License v3.0"),

    /** PHP License v3.01. */
    PHP_3_01("PHP-3.01", "PHP License v3.01"),

    /** Plexus Classworlds License. */
    PLEXUS("Plexus", "Plexus Classworlds License"),

    /** PostgreSQL License. */
    POSTGRE_SQL("PostgreSQL", "PostgreSQL License"),

    /** psfrag License. */
    PSFRAG("psfrag", "psfrag License"),

    /** psutils License. */
    PSUTILS("psutils", "psutils License"),

    /** Python License 2.0. */
    PYTHON_2_0("Python-2.0", "Python License 2.0"),

    /** Qhull License. */
    QHULL("Qhull", "Qhull License"),

    /** Q Public License 1.0. */
    QPL_1_0("QPL-1.0", "Q Public License 1.0"),

    /** Rdisc License. */
    RDISC("Rdisc", "Rdisc License"),

    /** Red Hat eCos Public License v1.1. */
    RHE_COS_1_1("RHeCos-1.1", "Red Hat eCos Public License v1.1"),

    /** Reciprocal Public License 1.1. */
    RPL_1_1("RPL-1.1", "Reciprocal Public License 1.1"),

    /** Reciprocal Public License 1.5. */
    RPL_1_5("RPL-1.5", "Reciprocal Public License 1.5"),

    /** RealNetworks Public Source License v1.0. */
    RPSL_1_0("RPSL-1.0", "RealNetworks Public Source License v1.0"),

    /** RSA Message-Digest License. */
    RSA_MD("RSA-MD", "RSA Message-Digest License"),

    /** Ricoh Source Code Public License. */
    RSCPL("RSCPL", "Ricoh Source Code Public License"),

    /** Ruby License. */
    RUBY("Ruby", "Ruby License"),

    /** Sax Public Domain Notice. */
    SAX_PD("SAX-PD", "Sax Public Domain Notice"),

    /** Saxpath License. */
    SAXPATH("Saxpath", "Saxpath License"),

    /** SCEA Shared Source License. */
    SCEA("SCEA", "SCEA Shared Source License"),

    /** Sendmail License. */
    SENDMAIL("Sendmail", "Sendmail License"),

    /** SGI Free Software License B v1.0. */
    SGI_B_1_0("SGI-B-1.0", "SGI Free Software License B v1.0"),

    /** SGI Free Software License B v1.1. */
    SGI_B_1_1("SGI-B-1.1", "SGI Free Software License B v1.1"),

    /** SGI Free Software License B v2.0. */
    SGI_B_2_0("SGI-B-2.0", "SGI Free Software License B v2.0"),

    /** Simple Public License 2.0. */
    SIM_PL_2_0("SimPL-2.0", "Simple Public License 2.0"),

    /** Sun Industry Standards Source License v1.2. */
    SISSL_1_2("SISSL-1.2", "Sun Industry Standards Source License v1.2"),

    /** Sun Industry Standards Source License v1.1. */
    SISSL("SISSL", "Sun Industry Standards Source License v1.1"),

    /** Sleepycat License. */
    SLEEPYCAT("Sleepycat", "Sleepycat License"),

    /** Standard ML of New Jersey License. */
    SMLNJ("SMLNJ", "Standard ML of New Jersey License"),

    /** Secure Messaging Protocol Public License. */
    SMPPL("SMPPL", "Secure Messaging Protocol Public License"),

    /** SNIA Public License 1.1. */
    SNIA("SNIA", "SNIA Public License 1.1"),

    /** Spencer License 86. */
    SPENCER_86("Spencer-86", "Spencer License 86"),

    /** Spencer License 94. */
    SPENCER_94("Spencer-94", "Spencer License 94"),

    /** Spencer License 99. */
    SPENCER_99("Spencer-99", "Spencer License 99"),

    /** Sun Public License v1.0. */
    SPL_1_0("SPL-1.0", "Sun Public License v1.0"),

    /** SugarCRM Public License v1.1.3. */
    SUGAR_CRM_1_1_3("SugarCRM-1.1.3", "SugarCRM Public License v1.1.3"),

    /** Scheme Widget Library (SWL) Software License Agreement. */
    SWL("SWL", "Scheme Widget Library (SWL) Software License Agreement"),

    /** TCL/TK License. */
    TCL("TCL", "TCL/TK License"),

    /** TCP Wrappers License. */
    TCP_WRAPPERS("TCP-wrappers", "TCP Wrappers License"),

    /** TMate Open Source License. */
    TMATE("TMate", "TMate Open Source License"),

    /** TORQUE v2.5+ Software License v1.1. */
    TORQUE_1_1("TORQUE-1.1", "TORQUE v2.5+ Software License v1.1"),

    /** Trusster Open Source License. */
    TOSL("TOSL", "Trusster Open Source License"),

    /** Unicode License Agreement - Data Files and Software (2015). */
    UNICODE_DFS_2015("Unicode-DFS-2015", "Unicode License Agreement - Data Files and Software (2015)"),

    /** Unicode License Agreement - Data Files and Software (2016). */
    UNICODE_DFS_2016("Unicode-DFS-2016", "Unicode License Agreement - Data Files and Software (2016)"),

    /** Unicode Terms of Use. */
    UNICODE_TOU("Unicode-TOU", "Unicode Terms of Use"),

    /** The Unlicense. */
    UNLICENSE("Unlicense", "The Unlicense"),

    /** Universal Permissive License v1.0. */
    UPL_1_0("UPL-1.0", "Universal Permissive License v1.0"),

    /** Vim License. */
    VIM("Vim", "Vim License"),

    /** VOSTROM Public License for Open Source. */
    VOSTROM("VOSTROM", "VOSTROM Public License for Open Source"),

    /** Vovida Software License v1.0. */
    VSL_1_0("VSL-1.0", "Vovida Software License v1.0"),

    /** W3C Software Notice and License (1998-07-20). */
    W3_C_19980720("W3C-19980720", "W3C Software Notice and License (1998-07-20)"),

    /** W3C Software Notice and Document License (2015-05-13). */
    W3_C_20150513("W3C-20150513", "W3C Software Notice and Document License (2015-05-13)"),

    /** W3C Software Notice and License (2002-12-31). */
    W3_C("W3C", "W3C Software Notice and License (2002-12-31)"),

    /** Sybase Open Watcom Public License 1.0. */
    WATCOM_1_0("Watcom-1.0", "Sybase Open Watcom Public License 1.0"),

    /** Wsuipa License. */
    WSUIPA("Wsuipa", "Wsuipa License"),

    /** Do What The F*ck You Want To Public License. */
    WTFPL("WTFPL", "Do What The F*ck You Want To Public License"),

    /** X11 License. */
    X11("X11", "X11 License"),

    /** Xerox License. */
    XEROX("Xerox", "Xerox License"),

    /** XFree86 License 1.1. */
    XFREE86_1_1("XFree86-1.1", "XFree86 License 1.1"),

    /** xinetd License. */
    XINETD("xinetd", "xinetd License"),

    /** X.Net License. */
    XNET("Xnet", "X.Net License"),

    /** XPP License. */
    XPP("xpp", "XPP License"),

    /** XSkat License. */
    XSKAT("XSkat", "XSkat License"),

    /** Yahoo! Public License v1.0. */
    YPL_1_0("YPL-1.0", "Yahoo! Public License v1.0"),

    /** Yahoo! Public License v1.1. */
    YPL_1_1("YPL-1.1", "Yahoo! Public License v1.1"),

    /** Zed License. */
    ZED("Zed", "Zed License"),

    /** Zend License v2.0. */
    ZEND_2_0("Zend-2.0", "Zend License v2.0"),

    /** Zimbra Public License v1.3. */
    ZIMBRA_1_3("Zimbra-1.3", "Zimbra Public License v1.3"),

    /** Zimbra Public License v1.4. */
    ZIMBRA_1_4("Zimbra-1.4", "Zimbra Public License v1.4"),

    /** zlib/libpng License with Acknowledgement. */
    ZLIB_ACKNOWLEDGEMENT("zlib-acknowledgement", "zlib/libpng License with Acknowledgement"),

    /** zlib License. */
    ZLIB("Zlib", "zlib License"),

    /** Zope Public License 1.1. */
    ZPL_1_1("ZPL-1.1", "Zope Public License 1.1"),

    /** Zope Public License 2.0. */
    ZPL_2_0("ZPL-2.0", "Zope Public License 2.0"),

    /** Zope Public License 2.1. */
    ZPL_2_1("ZPL-2.1", "Zope Public License 2.1");

    private final String code;
    private final String display;

    SPDXLicense(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/spdx-license";
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String display() {
        return display;
    }

    /**
     * Returns the constant for a code.
     *
     * @param code the code, which is case-sensitive
     * @return the constant
     * @throws IllegalArgumentException if the code system does not define the code
     */
    public static SPDXLicense fromCode(String code) {
        for (SPDXLicense value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SPDXLicense code: '" + code + "'");
    }
}
