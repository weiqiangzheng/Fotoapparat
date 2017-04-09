package io.fotoapparat.hardware.v2.captor;

import android.os.Build;
import android.support.annotation.RequiresApi;

import io.fotoapparat.hardware.v2.parameters.ParametersManager;
import io.fotoapparat.parameter.Flash;
import io.fotoapparat.parameter.FocusMode;
import io.fotoapparat.parameter.Parameters;

import static io.fotoapparat.hardware.v2.capabilities.FlashCapability.flashToAutoExposureMode;
import static io.fotoapparat.hardware.v2.capabilities.FlashCapability.flashToFiringMode;
import static io.fotoapparat.hardware.v2.capabilities.FocusCapability.focusToAfMode;
import static io.fotoapparat.parameter.Parameters.Type.FLASH;
import static io.fotoapparat.parameter.Parameters.Type.FOCUS_MODE;

/**
 *
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class RequestFieldsProvider {

	private final ParametersManager parametersManager;

	public RequestFieldsProvider(ParametersManager parametersManager) {
		this.parametersManager = parametersManager;
	}


	public Integer getFocusMode() {
		Parameters parameters = parametersManager.getParameters();
		FocusMode focusMode = parameters.getValue(FOCUS_MODE);
		return focusToAfMode(focusMode);
	}

	public Integer getAutoExposureMode() {
		Parameters parameters = parametersManager.getParameters();
		Flash flash = parameters.getValue(FLASH);
		return flashToFiringMode(flash);
	}

	public Integer getFlashFiringMode() {
		Parameters parameters = parametersManager.getParameters();
		Flash flash = parameters.getValue(FLASH);
		return flashToAutoExposureMode(flash);
	}
}
