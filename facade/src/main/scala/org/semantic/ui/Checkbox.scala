package org.semantic.ui

import org.querki.jquery.JQuery
import org.querki.jsext._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * http://semantic-ui.com/modules/checkbox.html
  */
class Checkbox(jq: JQuery) extends Jex(jq) {
  def toggle() = {
    dyno(_.checkbox("toggle"))
    this
  }

  def check() = {
    dyno(_.checkbox("check"))
    this
  }

  def uncheck() = {
    dyno(_.checkbox("uncheck"))
    this
  }

}

@ScalaJSDefined
trait CheckboxConfig extends js.Object

object CheckboxConfig extends CheckboxConfigBuilder(noOpts)

class CheckboxConfigBuilder(val dict: OptMap) extends JSOptionBuilder[CheckboxConfig, CheckboxConfigBuilder](new CheckboxConfigBuilder(_)) {
  def onChange(fun: js.Function0[Unit]) = jsOpt("onChange", fun)

  def onChecked(fun: js.Function0[Unit]) = jsOpt("onChecked", fun)

  def onUnchecked(fun: js.Function0[Unit]) = jsOpt("onUnchecked", fun)
}
