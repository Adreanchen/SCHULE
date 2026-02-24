<?php

use yii\helpers\Html;

/** @var yii\web\View $this */
/** @var app\models\Lieferanten $model */

$this->title = Yii::t('app', 'Update Lieferanten: {name}', [
    'name' => $model->LieferantenID,
]);
$this->params['breadcrumbs'][] = ['label' => Yii::t('app', 'Lieferantens'), 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->LieferantenID, 'url' => ['view', 'LieferantenID' => $model->LieferantenID]];
$this->params['breadcrumbs'][] = Yii::t('app', 'Update');
?>
<div class="lieferanten-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
