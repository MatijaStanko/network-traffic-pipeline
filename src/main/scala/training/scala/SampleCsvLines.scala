package training.scala

object SampleCsvLines {

  val lines: List[String] = List(
    "1784275200,router-1,router,interface-1,traffic-in,120000000,bps",
    "1784275500,router-1,router,interface-2,traffic-out,450,mbps",

    "abc,router-2,router,interface-1,traffic-in,100,bps",
    "1784275800,,router,interface-1,traffic-in,100,bps",
    "1784276100,router-2,router,,traffic-in,100,bps",
    "1784276400,router-2,router,interface-1,,100,bps",
    "1784276700,router-2,router,interface-1,traffic-in,abc,bps",
    "1784277000,router-2,router,interface-1,traffic-in,-100,bps",
    "1784277300,firewall-1,firewall,interface-1,traffic-in,100,bps",
    "1784281500,router-6,router,interface-1,traffic-in,250000000,bps",
    "1784281800,router-6,router,interface-2,traffic-out,340,mbps",
    "1784282100,cmts-3,cmts,upstream-1,utilization,42,percent",
    "1784282400,cmts-3,cmts,downstream-1,utilization,68,percent",
    "1784282700,cmts-3,cmts,downstream-2,modem-count,980,count",
    "1784283000,olt-3,olt,pon-1,signal-level,-16.5,dbm",
    "1784283300,olt-3,olt,pon-2,signal-level,-23.8,dbm",
    "1784283600,olt-3,olt,pon-3,subscriber-count,275,count",
    "1784283900,router-7,router,interface-1,traffic-in,810000000,bps",
    "1784284200,router-7,router,interface-2,traffic-out,925,mbps"
  )


}